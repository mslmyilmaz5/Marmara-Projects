#include <stdio.h>
#include <stdlib.h>
#include <math.h>



// Müslim Yýlmaz - 150119566 -

struct bst{
	int key;
	struct bst *rightPtr;
	struct bst *leftPtr;
};


int* get_inputs(int size){    // Getting  inputs and storing them into array.
	
	FILE *file = fopen("input.txt", "r");
	int numbers[size];
	int num,i=0;
    while(fscanf(file, "%d", &num) == 1) {
        numbers[i] = num;
        i++;
    }
    fclose(file);
    
   return numbers;
	
}

void decrasing_order_sort(int b[],int size){   // Sorting array elements by decrasing order
	
	for ( int i = 0 ; i < size; i++){
		for ( int j = i+1; j < size; j++){
			if (b[i] > b[j]){
				int temp = b[i];
				b[i] = b[j];
				b[j] = temp;
			}
		}
	}
}

struct bst* newNode(int item) // To crate the new node
{
    struct bst* temp
        = (struct bst*)malloc(sizeof(struct bst));
    temp->key = item;
    temp->leftPtr = NULL;
    temp->rightPtr = NULL;
    return temp;
}

  
struct bst* create_balanced_bst(int array_size,int low,int high,int b[]){  
/*Creating balanced binary search tree
with decreasing sort order array. */
	
	  if ( low > high){
	  	return NULL;
	  }
	  
	  int mid = (high + low)/2;
	  struct bst *root = (struct bst*)malloc(sizeof(struct bst));
	  root->key = b[mid];
	  root->leftPtr = NULL;
	  root->rightPtr = NULL;
	  root->leftPtr = create_balanced_bst(array_size,low,mid-1,b);
	  root->rightPtr = create_balanced_bst(array_size,mid+1,high,b);
   
	  return root;
}

struct bst* modify_tree(struct bst* root){ 
/*
Modifiying the array according to given  conditions.                                      
We have 2 case. This fuction implies case 1.
(e.g if we have 16 nodes, we have to carry two nodes to  the deep levels)
*/
	
	int transfered_key1 = root->rightPtr   // storing value of leftmost node's parent key
		->rightPtr->rightPtr->key;
       
	    int transfered_key2 = root->rightPtr->rightPtr  // storing value of letfmost node key
		->rightPtr->rightPtr->key;
	  	
	  	struct bst* node1 = newNode(transfered_key1);   // Creating two new nodes according to keys.
        struct bst* node2 = newNode(transfered_key2);
        
        struct bst* temp = root->rightPtr                // Deleting the nodes via to temp values.     
		->rightPtr->rightPtr;
		struct bst* temp1 = root->rightPtr->rightPtr
		->rightPtr->rightPtr;                                    
		free(temp);
		free(temp1);
		root->rightPtr->rightPtr = NULL;
		
		root->leftPtr->leftPtr                          // Locating same nodes into correct positions.
		->leftPtr->leftPtr = node1;
		
		node1->leftPtr = node2;
		
		return root;                                      
	
}

struct bst* modify_tree2(struct bst* root){
/* This fuction implies case 1.
(e.g if we have 18 nodes, we have to carry one node to  the deep level)
*/	
	  int transfered_key1 = root->rightPtr   
		->rightPtr->rightPtr->rightPtr->key;      // storing value of transfered key
		
	  struct bst* node1 = newNode(transfered_key1);    // Creating  new nodes according to key.
	  
	  struct bst* temp = root->rightPtr                   
		->rightPtr->rightPtr->rightPtr;                // Deleting the node via to temp values.
		
	  free(temp);
	  
	  root->rightPtr->rightPtr->rightPtr = NULL;
	  
	  root->leftPtr->rightPtr->rightPtr
	  ->rightPtr->rightPtr = node1;                    // Locating the node into correct positions.
	  
	  return root;
	  
}



int nodes_each_level(int depthlevel){  
/* Calculating each nodes in different 
depth levels when # nodes < 16 */
	
	
	double a = 2;
	double b = depthlevel;
	double total_node = pow(2,depthlevel);
	
	return total_node;	
}

int height_of_tree(struct bst* x){  // Finding the height of tree
	
	if ( x == NULL){
		return 0;
	}
	
	int left,right= 0;
	left = height_of_tree(x->leftPtr);
    right = height_of_tree(x->rightPtr);
    
    if ( left > right){
    	return left + 1;
	}
	else {
		return right + 1;
	}
}


int get_level(struct bst *node,int key, int level = 1)    // Finding the spesific depth level of node
                 
{
    if (node == NULL)
        return 0;
 
    if (node->key == key)
        return level;
 
    int leveld = get_level(node->rightPtr,key, level+1);
                                 
    if (leveld != 0)
    return leveld;
 
    leveld= get_level(node->leftPtr,key, level+1); 
                             
    return leveld;
}

int get_size(){      // Getting size of inputs.
	
	FILE *file = fopen("input.txt", "r");
	int num[100] = {0};
	int count= 0;
    while(fscanf(file, "%d", &num) == 1) {
        count++;
    }
    fclose(file);
    
   return count;
	
}



	


void display_part1(struct bst* x,int size,int depth_level){     // Display menu for case 1
	
		printf("\nDepth level of BST is %d",height_of_tree(x));
     
	for ( int i = 0; i <depth_level; i++){
		if ( i < 3){
			printf("\nDepth level %d is %d",i,nodes_each_level(i));
		}
		else if ( i == 3 )
		    printf("\nDepth level %d is %d",i,nodes_each_level(i) - 1);
		else {
			printf("\nDepth level %d is %d",i,1);
		}
	}
}

void display_part2(struct bst* x,int size,int depth_level){        // Display menu for case 2 
 	     
		  printf("\nDepth level of BST is %d",height_of_tree(x));
		int remains = get_size() - 15;  /*calculating remaining nodes after
		 depth level 3 (e.g 2^0 + 2^1 + 2^2 + 2^3) */
		for ( int i = 0; i < height_of_tree(x); i++){
			 if ( i < 4 )
			 printf("\nAt depth level %d %d",i,nodes_each_level(i));
			 else if (i == 4) 
			   printf("\nAt depth level %d %d",i,remains-1);  // case 2
			 else {
			   printf("\nAt depth level %d %d",i,1); 
			 }
}
}


int main(){

	int arr1[get_size()] = {0};    // initializing filled up array with 0's
	
	for ( int i = 0 ; i < get_size(); i++){
		arr1[i] = get_inputs(get_size())[i];   /* Checking that if inputs has negatif value or 0 , if not
		                                       store them into array */
		if ( arr1[i] < 0 || arr1[i] == 0)
		    printf("Error");
	}
	
	int array_size = get_size();
	decrasing_order_sort(arr1, array_size);
	struct bst *root = create_balanced_bst(array_size,0,array_size -1,arr1);
	
	if (get_size() == 16){
		modify_tree(root);
		display_part1(root,array_size,height_of_tree(root));       // case 1 
	}
	else{
		modify_tree2(root);
		display_part2(root,array_size,height_of_tree(root));     // case 2 
			
		
	}
		 
    int choise = -1;                    
	while ( choise != 0){
			
		    int	b =0;
			printf("\nKey value to be searched (Enter 0 to exit)");
			scanf("%d",&choise);
			for (int i = 0; i < array_size; i++){
	    	if (arr1[i] == choise){
	    		b = 1;
	    		break;
			} 
		}
		if ( b == 1){
			int dl = get_level(root,choise) - 1;
		     printf(" At depth level %d",dl);
		}
		else{
			if ( choise != 0)
			printf("%d is not found in BST",choise);
		}
	    }
	
}



