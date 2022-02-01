import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yhy
  implements View.OnClickListener, yjf
{
  public static String aYa = "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=%s&from=%s";
  private yjh a;
  private int bZe;
  private int bZf;
  private boolean bmJ;
  private SpannableString i;
  private QQAppInterface mApp;
  private Context mContext;
  private String mTroopUin;
  
  public yhy(QQAppInterface paramQQAppInterface, Context paramContext, yjh paramyjh)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.a = paramyjh;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.mContext).inflate(2131558703, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131362546);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131362556);
    ((TextView)paramVarArgs.findViewById(2131362557)).setText(this.i);
    if (this.bZe == 0)
    {
      localImageView1.setImageResource(2130839723);
      paramVarArgs.setBackgroundResource(2130839720);
      localImageView2.setImageResource(2130851155);
    }
    for (;;)
    {
      paramVarArgs.setOnClickListener(this);
      return paramVarArgs;
      localImageView1.setImageResource(2130845079);
      paramVarArgs.setBackgroundResource(2130848022);
      localImageView2.setImageResource(2130845250);
      localImageView2.setOnClickListener(this);
    }
  }
  
  public void a(String paramString, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    this.mTroopUin = paramString;
    this.i = paramSpannableString;
    this.bZe = paramInt1;
    this.bZf = paramInt2;
    if ((paramInt2 == 3) || (paramInt2 == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bmJ = bool;
      return;
    }
  }
  
  public int getType()
  {
    return 23;
  }
  
  public void h(int paramInt, Object... paramVarArgs) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BigTroopExpiredTipsBar", 2, "click tips, jump");
        }
        if (this.bmJ) {
          break;
        }
        localObject = new Intent(this.mContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", String.format(aYa, new Object[] { this.mTroopUin, "group_aio_tip" }));
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        this.mContext.startActivity((Intent)localObject);
        anot.a(this.mApp, "dc00898", "", "", "qq_vip", "0X8009E34", this.bZf, 0, "", "", "", "");
        this.a.ciA();
      }
      TroopManager.c.y(this.mContext, this.mTroopUin, "group_aio_tip");
      localQQAppInterface = this.mApp;
      if (this.bZf == 3) {}
      for (localObject = "0X800A57A";; localObject = "0X800A57C")
      {
        anot.a(localQQAppInterface, "dc00898", "", "", "qq_vip", (String)localObject, 1, 0, "", "", "", "");
        break;
      }
      localObject = (TroopManager)this.mApp.getManager(52);
      int j = ((TroopManager)localObject).cy(this.mTroopUin);
      ((TroopManager)localObject).dR(this.mTroopUin, j + 1);
      this.a.ciA();
    } while (!this.bmJ);
    QQAppInterface localQQAppInterface = this.mApp;
    if (this.bZf == 3) {}
    for (Object localObject = "0X800A57A";; localObject = "0X800A57C")
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "qq_vip", (String)localObject, 2, 0, "", "", "", "");
      break;
    }
  }
  
  public int wM()
  {
    return 25;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhy
 * JD-Core Version:    0.7.0.1
 */