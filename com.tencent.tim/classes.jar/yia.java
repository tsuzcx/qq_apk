import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class yia
  implements yjf
{
  public yjh a;
  String aYf;
  String aYg = "";
  String aYh = "";
  boolean bmK = false;
  Activity mActivity;
  QQAppInterface mApp;
  int type = -1;
  
  public yia(QQAppInterface paramQQAppInterface, yjh paramyjh, Activity paramActivity)
  {
    this.mApp = paramQQAppInterface;
    this.a = paramyjh;
    this.mActivity = paramActivity;
  }
  
  public int[] E()
  {
    return new int[0];
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2131558697, null);
    localView.setOnClickListener(new yib(this, localView));
    TextView localTextView = (TextView)localView.findViewById(2131362534);
    paramVarArgs = this.mActivity.getResources().getDisplayMetrics();
    int j = (int)(localTextView.getPaint().measureText(this.aYh) / this.aYh.length());
    int i;
    if (paramVarArgs.widthPixels > paramVarArgs.heightPixels)
    {
      i = paramVarArgs.heightPixels;
      i = (int)((i - paramVarArgs.density * 65.0F) / j) - 8;
      if (this.aYh.length() > i) {
        this.aYh = (this.aYh.substring(0, i) + "...");
      }
      if ((this.type < 100) || (this.type > 300)) {
        break label216;
      }
    }
    label216:
    for (paramVarArgs = acfp.m(2131704183);; paramVarArgs = acfp.m(2131704184))
    {
      this.aYf = String.format(paramVarArgs, new Object[] { this.aYh });
      localTextView.setText(this.aYf);
      return localView;
      i = paramVarArgs.widthPixels;
      break;
    }
  }
  
  public int getType()
  {
    return 13;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ComicTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
            }
            if ((this.mActivity != null) && (this.mActivity.getIntent() != null)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ComicTipsBar", 2, "onAIOEvent() : intent is null");
          return;
          paramVarArgs = this.mActivity.getIntent().getExtras();
          if (paramVarArgs != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ComicTipsBar", 2, "onAIOEvent() : data == null");
        return;
        this.bmK = paramVarArgs.getBoolean("fromMessage", false);
        this.aYg = paramVarArgs.getString("comicId");
        this.aYh = paramVarArgs.getString("comicName");
        this.type = paramVarArgs.getInt("type", -1);
        if (!TextUtils.isEmpty(this.aYh)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ComicTipsBar", 2, "onAIOEvent() : comicName is null");
      return;
      this.a.a(this, new Object[0]);
    } while (!QLog.isColorLevel());
    QLog.d("ComicTipsBar", 2, "onAIOEvent() : show ReaderTipBar, bookName : " + this.aYh);
  }
  
  public int wM()
  {
    return 35;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yia
 * JD-Core Version:    0.7.0.1
 */