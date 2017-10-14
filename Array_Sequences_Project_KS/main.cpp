#include <iostream>
#include"array.h"

using gor::array;
using namespace std;

int main() {
    array a;
    array b;
    cout << "====User input=============================================="<< endl;
    cout << "Please insert a number to the sequence" << endl;
    cin >> a;
    cout << "Sequence a is: " << a << endl << endl;

    cout << "====Insert_result==========================================="<< endl;
    a.insert(3);
    a.insert(5);
    a.insert(2);
    b.insert(1);
    b.insert(4);
    b.insert(7);
    b.insert(8);
    cout << "Sequence a is: " << a << endl;
    cout << "Sequence b is: " << b << endl << endl;

    cout << "====Insert_first_result====================================="<< endl;
    a.insert_first(2);
    cout << "Sequence a is now: " << a << endl << endl;

    cout << "====Insert_at(insert 3 at index 2)_result==================="<< endl;
    a.insert_at(3,2);
    cout << "Sequence a is now: " << a << endl << endl;

    cout << "====Erase_first_result======================================"<< endl;
    a.erase_first();
    cout << "Sequence a is now: " << a << endl << endl;

    cout << "====Erase_last_result======================================="<< endl;
    a.erase_last();
    cout << "Sequence a is now: " << a << endl << endl;

    cout << "====Erase_from index(4)_result=============================="<< endl;
    a.erase_from(4);
    cout << "Sequence a is now: " << a << endl << endl;

    cout << "====Count(3)_result========================================="<< endl;
    cout << "# of 3 in sequence a: " << a.count(3) << endl << endl;

    cout << "====a + 2_result============================================"<< endl;
    cout << "Sequence a is now: " << a + 2 << endl << endl;

    cout << "====a + b_result============================================"<< endl;
    cout << "Result of sequence a + b is: " << a + b << endl << endl;

    cout << "====a += b_result==========================================="<< endl;
    a += b;
    cout << "Sequence a is now: " << a << endl << endl;

    cout << "====a += (5)_result========================================="<< endl;
    a += 5;
    cout << "Sequence a is now: " << a << endl << endl;

    cout << "====(= 2)operator result===================================="<< endl;
    a = 2;
    cout << "Sequence a is now: " << a << endl << endl;

    cout << "====(= array)operator result================================"<< endl;
    a = b;
    cout << "Result of sequence a = b is now: " << a << endl;
    array c = a + b;
    cout << "Result of sequence (c = a + b) is now: " << c << endl << endl;

    cout << "====Erase_second_occurrence_of_4_result====================="<< endl;
    a.insert(4);
    cout << "Sequence a is: " << a << endl;
    a.erase_occurrence(4,2);
    cout << "Sequence a (after calling function) is now: " << a << endl << endl;

    cout << "====(==)operator result====================================="<< endl;
    b.erase_last();
    b.insert(2);
    cout << "Sequence a is: " << a << endl;
    cout << "Sequence b is: " << b << endl;
    if(a == b){
        cout << "Both sequence are identical" << endl;
    }
    else cout << "Both sequence are NOT identical" << endl << endl;

    cout << "====Increase_size(Reserve function)=========================" << endl;
    cout << "The capacity of sequence a is: " << a.get_capacity() << endl;
    for (int i = 0; i < 50 ; i++) {
        a.insert(i);
    }
    cout << "After inserting 50 numbers into sequence a,the capacity is now: " << a.get_capacity() << endl << endl;

    cout << "============================================================" << endl;
    //In the following test, we'll create a loop with 1,000,000,000 iterations,
    //add a number to each iterations and see the results.

    /*for (int j = 0; j < 1000000000 ; j++) {
        array memory_test;
        memory_test.insert(j);
    }*/

    //terminate called after throwing an instance of 'std::bad_alloc'
    //what():  std::bad_alloc
    //This application has requested the Runtime to terminate it in an unusual way.
    //Please contact the application's support team for more information.

    //Above is the error message from the complier, due to the failure of dynamic allocation.
    //Without a destructor, the memory will not automatically returns to the free memory from the heap.
    //Thus we need a destructor, every time when the insert function finished in each loop,
    //the heap will automatically returns to the free memory.

    return 0;

}

