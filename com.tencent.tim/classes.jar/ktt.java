import java.util.ArrayList;

class ktt
  extends ktr.a
{
  ktt(ktr paramktr, int paramInt)
  {
    super(paramktr, null);
  }
  
  void d(ktr.d paramd)
  {
    if (this.aLR == 1) {
      paramd.onCommentListLoad(1, false, new ArrayList(), false, 3, 3);
    }
    while (this.aLR != 2) {
      return;
    }
    paramd.onCommentLoadMore(1, false, new ArrayList(), false, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktt
 * JD-Core Version:    0.7.0.1
 */