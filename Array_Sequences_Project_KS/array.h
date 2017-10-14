//
// Created by Gor on 3/21/2017.
//

#ifndef SEQUENCE_ARRAY_H
#define SEQUENCE_ARRAY_H

#include <iostream>
#include <algorithm>
#include <cassert>

namespace gor {

    class array {
    public:
        friend std::istream &operator>>(std::istream &ins, array &a);
        friend std::ostream &operator<<(std::ostream &out, const array &a);

        typedef int value_type;
        typedef size_t size_type;

        ~array();                                                              //destructor
        static const size_type DEFAULT_CAPACITY = 25;
        array(size_type initial_capacity = DEFAULT_CAPACITY);                 //default constructor
        void increase_size(size_type capacity);                               //A reserve function for further expansion of the
                                                                              //size of the sequence
        array(const array &source);                                           //copy constructor
        size_type get_used() const { return used; }
        size_type get_capacity() const { return capacity; }

        void erase_first();                                                     //erase the first data from an specific array
        void erase_last();                                                      //erase the last data from an specific array
        void erase_from(int item);                                             //remove element form a specific index
        void erase_occurrence(const value_type num, const value_type index);  //remove the occurrence of the x element
        void insert(const value_type &num);                                   // insert data to the array
        value_type count(const value_type target);                           //count the occurrence of an element in an array
        void insert_first(value_type item);                                   //insert a data to the first index of an array
        void insert_at(const value_type input, const value_type index);      //insert a data to a specific index of a sequence

        void operator+=(const array &a1);
        void operator+=(const value_type num);
        array operator+(const array::value_type input);
        array& operator=(const array &source);
        void operator=(const value_type num);
        bool operator==(const array& a1);

    private:
        value_type *data;                                       //pointer to the dynamic array
        size_type used;                                         //How much of array is being used
        size_type capacity;                                     //current capacity of the bag
    };

    array operator+(const array &a1, const array &a2);

}

#endif //SEQUENCE_ARRAY_H
