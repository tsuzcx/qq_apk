import java.util.ArrayList;

class ktu
  extends ktr.a
{
  ktu(ktr paramktr, int paramInt)
  {
    super(paramktr, null);
  }
  
  void d(ktr.d paramd)
  {
    if (this.aLR == 1) {
      paramd.onCommentListLoad(1, false, new ArrayList(), false, 6, 6);
    }
    while (this.aLR != 2) {
      return;
    }
    paramd.onCommentLoadMore(1, false, new ArrayList(), false, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktu
 * JD-Core Version:    0.7.0.1
 */