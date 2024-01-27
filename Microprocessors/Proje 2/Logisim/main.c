#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void read_int(int *, int *);

int main(){
    //dont use register 0, use register 1 for printing results
    int acc,lastRead,operand,operation;
    read_int(&acc,&lastRead); //Print readed value to sevensegment if pb2 == 1;
    while(1){
        if(lastRead == 12){
            break;
        }
        operation = lastRead;
        read_int(&operand,&lastRead);
        switch(operation) {
            case 15:
                acc += operand;
                break;
            case 14:
                acc -= operand;
                break;
            case 13:
                acc *= operand;
                break;
        }
        //Print acc value to sevensegment if pb2 == 1
    }
    printf("%d",acc); //Print result to sevensegment if pb2 == 1;
}

void read_int(int *value,int *lastRead){
    int input;
    *value = 0;
    scanf("%d",&input);
    while(input <= 9){
        *value = *value * 10 + input;
        scanf("%d",&input);
    }
    *lastRead = input;
}
