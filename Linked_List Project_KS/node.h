//
// Created by Ka Shing Wai on 4/3/2017.
//

#ifndef LINKED_LIST_NODE_H
#define LINKED_LIST_NODE_H

#include <iostream>

namespace gor {
    template <class T>
    class sequence{
    public:
        //CONSTRUCTOR
        sequence(){
            head_ptr = tail_ptr = NULL;
            length = 0;
        }

        //DESTRUCTOR
        ~sequence(){
            while (head_ptr != NULL){
                this->remove_head();
            }
            length = 0;
        }

        //FRIEND FUNCTIONS
        template <class R>
        friend std::istream & operator >>(std::istream &ins, sequence <R>& source);        //input operator
        template <class R>
        friend std::ostream & operator <<(std::ostream &out, const sequence <R>& source); //output operator
        template <class R>
        friend sequence<R> operator + (const sequence<R> & s1, const sequence<R> & s2);  //adding two linked lists
        template <class R>
        friend sequence<R> operator + (const sequence<R> & s1, const R & value);         //adding a value to a linked list.

        //MEMBER FUNCTIONS
        void insert_head(const T &);                  //insert a data to the head of the linked list
        void insert_tail(const T &);                  //insert a data to the tail of the linked list
        void insert_at(T index, const T data);        //insert a data to specific index of the linked list
        void remove_head();                            //remove a head node of a linked list
        void remove_tail();                            //remove a tail node of a linked list
        void remove_from(T index);                     //remove a node from a specific index of a linked list.
        void remove_occur(T occur, T value);           //remove the specific occurrence of a selected data in a linked list
        int count(const T data);                      //count the occurrence of an element in an linked list

        T & operator [](const T & index);     //I used the [] operator instead of making a iterator class
                                               //In the main.cpp, I will use the regular for loop(int i...)
                                               //Then use the overloaded [] operator to output the linked list.

        //OPERATORS
        void operator += (const sequence<T> & s2);  //adding two linked list and return "this" linked list.
        void operator += (const T & value);         //adding a number to "this" linked list and output.
        void operator =  (const sequence<T> & s2);  //assignment operator (to linked list)
        void operator =  (const T & value);         //assignment operator (to a value)
        bool operator ==(const sequence<T> & s2);   //check the equality of two linked lists

        size_t get_length() const { return length;} //perform same functionality as the "size" function

    private:
        class node {
        public:
            //CONSTRUCTOR
            node(const T &init_data = T(), node *init_link = NULL) {
                m_data = init_data;
                m_next = init_link;
            }

            const node *link() const { return m_next; }             //returns the next node pointer (const)
            node *link() { return m_next;}                           //returns the next node pointer
            void set_link(node *new_link) { m_next = new_link; }     //set the next node pointer
            void set_data(const T &new_data) { m_data = new_data; } //set the data of a node
            const T data() { return m_data; }                       //get the data from a node
            T m_data;
        private:
            node *m_next;
            node *m_previous;                     //This private member is for doubly linked list.
                                                  //Advantage: 1) We can traverse the linked list in both directions.
                                                  //              Not necessary to traverse the linked list based on the previous_ptr.
                                                  //           2) It is easier to reverse the linked list since we have can track back to the previous node.

        };
        size_t length ;
        node *head_ptr;
        node *tail_ptr;
    };

#include "node.template"

}

#endif //LINKED_LIST_NODE_H