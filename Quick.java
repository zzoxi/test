public class Quick {
    public static void sort(Comparable[] a){
        //可以加一句把输入打乱 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a, lo, hi); //切分
        sort(a, lo, j-1);
        sort(a,j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)) if(i == hi) break;//注意顺序 只能左先动，然后再右边动
            while(less(v,a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    private static void exch(Comparable[] a, int lo ,int hi){
        Comparable temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }
    private static boolean less(Comparable a, Comparable b){
        return a<b;
    }
}
