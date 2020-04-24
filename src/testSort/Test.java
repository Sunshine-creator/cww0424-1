package testSort;

import java.util.Arrays;

public class Test {
    public static void insert(int [] array){    //插入排序
        for(int bound=1;bound<array.length;bound++){
            int v = array[bound];  //取出当前元素
            int cur = bound-1;  //已排序元素的最后一个元素下标
            for(;cur>=0;cur--){
                if(array[cur]>v){
                    array[cur+1]=array[cur];   //前面的元素比后面小，就交换
                }else{      //更改下标
                      break;
                }
            }
            array[cur+1]=v;  //
        }
    }
    public static void shell(int array[]){       //希尔排序
        int gap = array.length/2;   //gap，分组次数
        while (gap>1){
            insertGap(array,gap);
            gap/=2;
        }
        insertGap(array,1);
    }
    private static void insertGap(int[] array, int gap) {
        for(int bound=gap;bound<array.length;bound++){
            int v = array[bound];  //取出当前元素
            int cur = bound-gap;  //已排序元素的最后一个元素下标,小于零进不去循环,同组中的上一个元素
            for(;cur>=0;cur-=gap){
                if(array[cur]>v){
                    array[cur+gap]=array[cur];   //前面的元素比后面小，就交换
                }else{      //更改下标
                    break;
                }
            }
            array[cur+gap]=v;  //
        }
    }
   public static void select(int [] array){   //选择排序
        for(int bound=0;bound<array.length;bound++){
            for(int cur=bound+1;cur<array.length;cur++){    //进行大擂主
                if(array[cur]<array[bound]){
                    int temp=array[cur];
                    array[cur]=array[bound];
                    array[bound]=temp;
                }
            }
        }
   }
   public static void swap(int[] array,int i,int j){     //一会调用堆顶元素
        int temp = array[i];
        array[i]=array[j];
        array[j] = temp;
   }
   public static void heap(int [] array){    //堆排序
        createHeap(array);   //创建一个堆
       for (int i = 0; i <array.length-1 ; i++) {  //循环次数length-1,当只剩最后一个元素，也就一定是有序的
           swap(array,0,array.length-1-i); //这里最后一个元素都在变换
           shiftDown(array,array.length-i-1,0);
       }
   }

    private static void shiftDown(int[] array, int heapLength, int index) {  //index重哪个地方开始
        int parent=index;
        int child =2*parent+1;        //建个大堆
        while(child<heapLength){
            if(child+1<heapLength && array[child] < array[child+1]){    //求出左右子树中的较大值值
                child=child+1;     //
            }
            //child是左右子树中比较大的值的下标
            if(array[child] > array[parent]){   //和根节点比较大小，打的话就交换
                swap(array,child,parent);
            }else {
                break;
            }
            parent=child;
            child=2*parent+1;
        }
    }

    private static void createHeap(int[] array) {
        //最后一个非叶子节点循环找，一次进行向下调整
        for(int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }
    public static void main(String[] args) {
        int array[] ={9,5,2,7,23,28,17};
        heap(array);
        System.out.println(Arrays.toString(array));
    }
}
