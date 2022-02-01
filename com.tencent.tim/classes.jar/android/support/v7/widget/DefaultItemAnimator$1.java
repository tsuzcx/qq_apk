package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator$1
  implements Runnable
{
  DefaultItemAnimator$1(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$moves.iterator();
    while (localIterator.hasNext())
    {
      DefaultItemAnimator.MoveInfo localMoveInfo = (DefaultItemAnimator.MoveInfo)localIterator.next();
      DefaultItemAnimator.access$000(this.this$0, localMoveInfo.holder, localMoveInfo.fromX, localMoveInfo.fromY, localMoveInfo.toX, localMoveInfo.toY);
    }
    this.val$moves.clear();
    DefaultItemAnimator.access$100(this.this$0).remove(this.val$moves);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */