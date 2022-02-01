import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;

public class agxo
  extends ahda
{
  private TextView SB;
  private TextView SC;
  private View.OnClickListener fc = new agxp(this);
  
  public agxo(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    initView();
  }
  
  private void initView()
  {
    this.SB = ((TextView)this.a.M(2131377979));
    this.SC = ((TextView)this.a.M(2131372449));
    this.SB.setOnClickListener(this.fc);
  }
  
  public void cD(Bundle paramBundle)
  {
    super.cD(paramBundle);
    if (this.cgf) {}
  }
  
  public void dko()
  {
    Object localObject = this.mContext.getString(2131693511) + this.mContext.getString(2131693788) + agmz.fN() + this.mContext.getString(2131693789);
    long l = agmz.fP();
    String str = "";
    if (l > 0L) {
      str = this.mContext.getString(2131693579) + ahbj.g(l);
    }
    this.SB.setText((CharSequence)localObject);
    localObject = this.SB;
    if (agmz.fN() > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject).setEnabled(bool);
      this.SC.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxo
 * JD-Core Version:    0.7.0.1
 */