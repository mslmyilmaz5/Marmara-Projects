#include <stdio.h>

int main()
{
  unsigned int x=0x4D6,bcd=0; 
  
  int i;
  
  for(i=13;i>=0;i--)
   {  
      bcd<<=1;
      if(x&(1<<i))
      {
         bcd|=1;
      } 
      if(i == 0){
         break;
      }
      if((bcd&0xf)>0x4)
      {
         printf("\n----0----\n");
         bcd+=3;
      }
      
      if((bcd&0xf0)>0x40)
      {
         printf("\n----1----\n");
         bcd+=0x30;
      }
      
      if((bcd&0xf00)>0x400)
      {
         printf("\n----2----\n");
         bcd+=0x300;
      }
      
      if((bcd&0xf000)>0x4000)
      {
         printf("\n----3----\n");
         bcd+=0x3000;
      }


      printf("end bcd=%x \n",bcd);
  }

  printf("x(hex)=%x \nx(dec)=%d \nbcd=%x\n",x,x,bcd); 

  return 0;
}