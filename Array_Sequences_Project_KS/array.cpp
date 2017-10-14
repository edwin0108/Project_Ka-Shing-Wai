//
// Created by Gor on 3/21/2017.
//

#include "array.h"

namespace gor {

    //default constructor
    array::array(size_type initial_capacity) {
        data = new value_type[initial_capacity];
        capacity = initial_capacity;
        used = 0;
    }

    //copy constructor
    array::array(const array &source) {
        data = new value_type[source.capacity];
        capacity = source.capacity;
        used = source.used;
        std::copy(source.data, source.data + used, data);
    }

    //destructor
    array::~array() {
        delete[] data;
    }


    void array::increase_size(array::size_type in_capacity) {
        if (in_capacity == capacity) {
            return;
        }
        //check if the results exceeds the capacity of the sequence

        if (in_capacity < used)
            in_capacity = used;

        value_type *newdata = new value_type[in_capacity];
        for (int i = 0; i < used; i++) {
            newdata[i] = data[i];
        }
        delete [] data;
        data = newdata;
        capacity = in_capacity;
    }


    std::istream &operator>>(std::istream &ins, array &a) {
        ins >> a.data[a.used++];
        return ins;
    }

    std::ostream &operator<<(std::ostream &out, const array &a) {
        for (int i = 0; i < a.used; i++) {
            out << a.data[i];
        }
        return out;
    }

    void array::insert(const value_type &num) {
        if (used == capacity) {
            increase_size(used + 1);
        }
        //check if the results exceeds the capacity of the sequence

        data[used++] = num;
    }

    void array::insert_at(const array::value_type input,const array::value_type index) {
        if (used < index){
            insert(input);
        }
        //check if the results exceeds the capacity of the sequence

        if (used == capacity){
            increase_size( used + 1);
        }

        for (int i = used + 1; i > index ; i--) {
            data[i] = data[i - 1];
        }
        data[index] = input;
        used++;
    }

    void array::insert_first(array::value_type item) {
        if(used == capacity){
            increase_size(used + 1);
        }
        //check if the results exceeds the capacity of the sequence

        for (int i = used + 1; i != 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = item;
        used++;
    }

    array::value_type array::count(const value_type target) {
        int num = 0;
        for (int i = 0; i < used; i++) {
            if (target == data[i]) {
                num++;
            }
        }
        return num;
    }

    void array::erase_first() {
        assert(used != 0); //check if the pre-condition meets (used must greater than 0)
        used--;
        if (used > 0) {
            for (int i = 0; i < used; i++) {
                data[i] = data[i + 1];
            }
        }
    }

    void array::erase_last() {
        assert(used != 0); //check if the pre-condition meets (used must greater than 0)
        data[used--] = {};
    }

    void array::erase_occurrence(const value_type num, const value_type index) {
        assert(used != 0); //check if the pre-condition meets (used must greater than 0)
        value_type occur;
        value_type count = 0;
        for (int i = 0; i < used; i++) {
            if (data[i] == num) {
                occur = i;
                count++;
                if (count == index) {
                    erase_from(occur);
                }
            }
        }
    }

    void array::erase_from(int index) {
        for (int i = index; i < used; i++) {
            data[i] = data[i + 1];
        }
        data[--used] = {};
    }

    bool array::operator==(const array& a1) {
        if (a1.get_used() != used) {
            return false;
        }
        for (int i = 0; i < used; i++) {
            if(a1.data[i] != data[i]){
                return false;
            }
        }
        return true;
    }

    array operator+(const array &a1, const array &a2) {
        array result;
        if (a1.get_used() + a2.get_used() > result.get_capacity()){
            result.increase_size(a1.get_used() + a2.get_used());
        }
        //check if the results exceeds the capacity of the sequence

        result += a1;
        result += a2;
        return result;
    }

    array array::operator+(const array::value_type input) {
        array result;

        if(used + 1 > result.get_capacity()){
            increase_size(used + 1);
        }
        //check if the results exceeds the capacity of the sequence

        for (int i = 0; i < used ; i++) {
            result.data[i] = data[i];
            result.used++;
        }

        result.data[result.used++] = input;
        return result;
    }

    void array::operator+=(const array &p1) {
        if (used + p1.used > capacity) {
            increase_size(used + p1.used);
        }
        //check if the results exceeds the capacity of the sequence

        for (int i = 0; i < p1.used; i++) {
            data[used++] = p1.data[i];
        }
    }

    void array::operator+=(const array::value_type num) {
        if (++used > capacity) {
            increase_size(num + used);
        }
        //check if the results exceeds the capacity of the sequence
            data[used - 1] = num;
    }

    void array::operator=(const array::value_type num) {
        used = 0;
        data[used++] = num;
    }

    array& array::operator=(const array &source) {
        if(used + source.used > capacity){
            increase_size(used + source.used);
        }
        //check if the results exceeds the capacity of the sequence
        used = 0;
        for (int i = 0; i < source.used ; i++) {
            data[i] = source.data[i];
            used++;
        }
        return *this;
    }

}