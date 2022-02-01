import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class yjc
  implements yjf
{
  private Context J;
  private yjh a;
  protected String aYn;
  private String aYo;
  private QQAppInterface app;
  private String hU;
  private Intent mIntent;
  
  public yjc(QQAppInterface paramQQAppInterface, yjh paramyjh, Context paramContext, Intent paramIntent)
  {
    this.app = paramQQAppInterface;
    this.a = paramyjh;
    this.J = paramContext;
    this.mIntent = paramIntent;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.J).inflate(2131558701, null);
    paramVarArgs.setOnClickListener(new yjd(this));
    ((TextView)paramVarArgs.findViewById(2131362555)).setText(this.aYn);
    return paramVarArgs;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ReaderTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
          }
          paramVarArgs = this.mIntent.getExtras();
          if (paramVarArgs != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ReaderTipsBar", 2, "data == null");
        return;
        str = paramVarArgs.getString("bookname");
        if (!TextUtils.isEmpty(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ReaderTipsBar", 2, "onAIOEvent() : bookName is empty");
      return;
      this.aYn = String.format(acfp.m(2131713610), new Object[] { str });
      this.hU = paramVarArgs.getString("bookid");
      this.aYo = paramVarArgs.getString("book_new_id");
      this.a.a(this, new Object[0]);
    } while (!QLog.isColorLevel());
    QLog.d("ReaderTipsBar", 2, "onAIOEvent() : show ReaderTipBar, bookName : " + str);
  }
  
  public int wM()
  {
    return 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjc
 * JD-Core Version:    0.7.0.1
 */