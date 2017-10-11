#RSA_Algorithm_Project
#Created by KA_SHING_WAI on 4/6/16

#---------------------------------------------------------------------------------------
#|This is a cryptosystem which can securely send messages to recipients.               |
#|By generating a "random specific" public key and private key to encrypt the messages.|
#|Recipients will use the public key and private to decrypt messages.                  |
#---------------------------------------------------------------------------------------

from random import randint
import math

#Check if n is a prime
def isPrime(n):
    if n < 2:
        return False
    for i in range(2,int(math.sqrt(n))+1):
        if n%i==0:
            return False
    return True

#Picking prime in a given range
def pick_prime():
    a = False
    while not a:
        n = randint(1,200)
        if isPrime(n):
            return n

#GCD
def gcd(a,b):
	if b==0:
	    return a
	else:
	    return gcd(b,a%b)
	
#pick a number in range 1 < e < phi
def e(phi):
    e = randint(2, phi)
    while (gcd(e,phi) != 1):
        e = randint(2, phi)
    return e


def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, y, x = egcd(b % a, a)
        return (g, x - (b // a) * y, y)

#Applying Extended Euclidean Algorithm to generate d
def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m

#Encrypt & Decrypt=====================================================

def encrypt(string,E,N):
    c = [(ord(char) ** E ) % N for char in string]
    return c

def decrypt(num, d, N):
    plain = [chr((char ** d) % N) for char in num]
    return ''.join(plain)

#Testing===============================================================

def main():
    p = pick_prime()
    q = pick_prime()
    phi = (p-1)*(q-1)
    N = p * q
    E = e(phi)
    d = modinv(E, phi)
    print ("RSA Encrypter / Decrypter, by KA SHING WAI")
    print ("Public key (N,e) is: ",(N,E))
    
    while p > 1:
        print("Enter a negative number for encryption.")
        print("Enter a positive number for decryption.")
        print("Enter 0 to exit the program:")
        n = eval(input())
        print("")
        if n == 0:
            break
        if n < 0:
            N, E = eval(input("Enter a public key(N,E): "))
            message = str(input("Enter a message to decrypt: "))
            en = encrypt(message,E,N)
            print("Your encrypted numbers are:",en)
            print("")
            print("=====End of program=====")
            print("")
        if n > 0:
            decrypt_list = eval(input("Enter numbers (seperate with comma) to decrypt message: "))
            dy = decrypt(decrypt_list, d, N)
            print("Your decrypted message is: ",dy)
            print("")
            print("=====End of program=====")
            print("")

main()

