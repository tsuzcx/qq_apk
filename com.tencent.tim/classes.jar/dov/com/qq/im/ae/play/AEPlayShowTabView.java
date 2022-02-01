package dov.com.qq.im.ae.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import dov.com.qq.im.capture.view.QIMSlidingTabView;
import dov.com.qq.im.capture.view.QIMSlidingTabView.b;
import java.util.ArrayList;
import java.util.List;

public class AEPlayShowTabView
  extends QIMSlidingTabView
{
  private int curIndex;
  private ArrayList<QIMSlidingTabView.b> kr;
  
  public AEPlayShowTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void TX(int paramInt)
  {
    super.TX(paramInt);
    this.curIndex = paramInt;
    ArrayList localArrayList = dy();
    if (localArrayList == null) {
      return;
    }
    int i = 0;
    label22:
    View localView;
    if (i < localArrayList.size())
    {
      localView = (View)localArrayList.get(i);
      if (i != paramInt) {
        break label70;
      }
      localView.setScaleX(1.143F);
      localView.setScaleY(1.143F);
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label70:
      localView.setScaleX(1.0F);
      localView.setScaleY(1.0F);
    }
  }
  
  public void eL(ArrayList<QIMSlidingTabView.b> paramArrayList)
  {
    this.kr = paramArrayList;
    super.eL(paramArrayList);
  }
  
  public int getCurIndex()
  {
    return this.curIndex;
  }
  
  public ArrayList<QIMSlidingTabView.b> getDataList()
  {
    return this.kr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowTabView
 * JD-Core Version:    0.7.0.1
 */