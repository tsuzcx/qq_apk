import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;

public abstract interface nid
{
  public abstract void d(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo);
  
  public abstract View getContentView();
  
  public abstract void onDestroy();
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nid
 * JD-Core Version:    0.7.0.1
 */