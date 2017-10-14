#include <iostream>
#include "node.h"

using namespace std;
using gor::sequence;

int main() {
    sequence<int> a;
    sequence<int> b;
    cout << "====insert_head function===========================================" << endl;
    a.insert_head(5);
    a.insert_head(6);
    a.insert_head(104);
    cout << "Linked list A is now: " << a << endl;
    cout << "====insert_tail function===========================================" << endl;
    a.insert_tail(10);
    a.insert_tail(20);
    cout << "Linked list A is now: " << a << endl;
    cout << "====Cin (istream) function==========================" << endl;
    cout << "Please insert a data to linked list B: " << endl;
    cin >> b;
    cout << "Linked list B is now: " << b << endl;
    cout << "====remove_head function===========================================" << endl;
    a.remove_head();
    cout << "Linked list A is now: " << a << endl;
    cout << "====get_length(count) function=====================================" << endl;
    cout << "The length of linked list a is: " << a.get_length() << endl;
    cout << "====remove_tail function===========================================" << endl;
    a.remove_tail();
    cout << "Linked list A is now: " << a << endl;
    a.insert_tail(4);
    a.insert_tail(8);
    cout << "====remove_from function===========================================" << endl;
    cout << "Linked list A is now (before removal): " << a << endl;
    a.remove_from(3);
    cout << "Linked list A is now (removing the third node): " << a << endl;
    cout << "====Count function================================================= " << endl;
    cout << "The occurrence of data 5 in linked list A is: " << a.count(5) << endl;
    a.insert_at(2,3);
    a.insert_tail(5);
    cout << "Linked list A (after inserting 3 at index 2) is now : " << a << endl;
    cout << "====Remove_occur function==========================================" << endl;
    cout << "Linked list A is now: " << a << endl;
    a.remove_occur(1,5);
    b.insert_tail(105);
    b.insert_head(10);
    cout << "Linked list A (after removing the first 5) is now: " << a << endl;
    cout << "Linked list B is now: " << b << endl;
    cout << "====(+= linked list)===============================================" << endl;
    a += b;
    cout << "Linked list A (after a += b) is now: " << a << endl;
    cout << "The length of linked list a is: " << a.get_length() << endl;
    cout << "====(+= value)=====================================================" << endl;
    a += 2;
    cout << "Linked list A (after a += 2) is now: " << a << endl;
    cout << "The length of linked list a is: " << a.get_length() << endl;
    cout << "====(= linked list)================================================" << endl;
    a = b;
    cout << "Linked list A (after a = b) is now: " << a << endl;
    cout << "The length of linked list a is: " << a.get_length() << endl;
    cout << "====(= value)======================================================" << endl;
    a = 1854;
    cout << "Linked list (after a = 1854) A is now: " << a << endl;
    cout << "The length of linked list a is: " << a.get_length() << endl;
    cout << "====(+ linked list)================================================" << endl;
    cout << "The result of a + b is: " << a + b << endl;
    cout << "The result of b + a is: " << b + a << endl;
    cout << "Linked list A is now : " << a << endl;
    cout << "Linked list B is now : " << b << endl;
    cout << "The length of linked list a is: " << a.get_length() << endl;
    cout << "====(+ value)======================================================" << endl;
    cout << "The result of a + 90 is: " << a + 90 << endl;
    cout << "The result of b + 38 is: " << b + 38 << endl;
    cout << "====(== bool operator)=============================================" << endl;
    a = b;
    cout << "Linked list A (after a = b) is now: " << a << endl;
    cout << "Linked list b is now: " << b << endl;
    if (a == b){
        cout << "Both linked list are identical" << endl;
    }
    else
        cout << "Both linked list are NOT identical." << endl;
    cout << "Now adding 2 different int, with both linked list the same length"<< endl;
    a.insert_tail(100);
    b.insert_tail(99);
    cout << "Linked list A is now: " << a << endl;
    cout << "Linked list B is now: " << b << endl;
    if (a == b){
        cout << "Both linked list are identical." << endl;
    }
    else
        cout << "Both linked list are NOT identical." << endl;

    cout << "====(ITERATOR using [] operator)===================================" << endl;
    cout << "Linked list A (using iterator) is now: ";
    for(int i = 0; i < a.get_length(); i++){
        cout << a[i] << "-->";
    }
    cout << endl;
    cout << "Linked list A is now: " << a << endl;
    cout << "The length of linked list a is: " << a.get_length() << endl;
    return 0;
}

