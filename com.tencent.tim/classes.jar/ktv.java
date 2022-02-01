import java.util.ArrayList;

class ktv
  extends ktr.a
{
  ktv(ktr paramktr, int paramInt)
  {
    super(paramktr, null);
  }
  
  void d(ktr.d paramd)
  {
    if (this.aLR == 1) {
      paramd.onCommentListLoad(2, false, new ArrayList(), false, 4, 4);
    }
    while (this.aLR != 2) {
      return;
    }
    paramd.onCommentLoadMore(2, false, new ArrayList(), false, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktv
 * JD-Core Version:    0.7.0.1
 */