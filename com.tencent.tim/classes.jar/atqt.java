import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.fileassistant.QfileFileAssistantActivity;

public class atqt
  implements View.OnClickListener
{
  public atqt(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QfileFileAssistantActivity.a(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.i(QfileFileAssistantActivity.TAG, 2, "click too fast , wait a minute.");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QfileFileAssistantActivity.a(this.this$0);
      Object localObject1 = (atwc.a)paramView.getTag();
      if (((atwc.a)localObject1).category != 0)
      {
        long l = ((atwc.a)localObject1).category;
        Object localObject3;
        Object localObject2;
        switch ((int)l)
        {
        case 18: 
        case 20: 
        default: 
          if (QLog.isColorLevel()) {
            QLog.e(QfileFileAssistantActivity.TAG, 2, "unknow category!!! return onClick");
          }
          break;
        case 12: 
          localObject1 = new audw.b();
          ((audw.b)localObject1).bJE = "file_assistant_in";
          ((audw.b)localObject1).cYX = 1;
          audw.a(this.this$0.app.getCurrentAccountUin(), (audw.b)localObject1);
          localObject3 = new Intent(this.this$0.getApplicationContext(), LiteActivity.class);
          localObject1 = localObject3;
          if (this.this$0.cdf)
          {
            audw.JH("0X8005534");
            localObject1 = localObject3;
          }
        case 13: 
        case 14: 
        case 19: 
        case 15: 
          for (;;)
          {
            try
            {
              localObject3 = new Bundle();
              ((Bundle)localObject3).putLong("category", l);
              ((Intent)localObject1).putExtra("bundle", (Bundle)localObject3);
              ((Intent)localObject1).putExtra("from", "FileAssistant");
              this.this$0.startActivityForResult((Intent)localObject1, 101);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            break;
            localObject2 = new audw.b();
            ((audw.b)localObject2).bJE = "file_assistant_in";
            ((audw.b)localObject2).cYX = 2;
            audw.a(this.this$0.app.getCurrentAccountUin(), (audw.b)localObject2);
            localObject3 = new Intent(this.this$0.getApplicationContext(), FMActivity.class);
            ((Intent)localObject3).putExtra("tab_tab_type", 7);
            localObject2 = localObject3;
            if (this.this$0.cdf)
            {
              audw.JH("0X8005537");
              localObject2 = localObject3;
              continue;
              localObject2 = new audw.b();
              ((audw.b)localObject2).bJE = "file_assistant_in";
              ((audw.b)localObject2).cYX = 3;
              audw.a(this.this$0.app.getCurrentAccountUin(), (audw.b)localObject2);
              QfileFileAssistantActivity.b(this.this$0);
              if (!this.this$0.cdf) {
                break;
              }
              audw.JH("0X800553A");
              break;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putBoolean("string_from", false);
              ((Bundle)localObject2).putBoolean("string_uin", false);
              ((Bundle)localObject2).putLong("device_din", 0L);
              ((Bundle)localObject2).putInt("sTitleID", 0);
              avio.b(this.this$0, (Bundle)localObject2, "com.qqdataline.mpfile.LiteMpFileMainActivity");
              if (!this.this$0.cdf) {
                break;
              }
              audw.JH("0X8005539");
              break;
              localObject2 = new audw.b();
              ((audw.b)localObject2).bJE = "file_assistant_in";
              ((audw.b)localObject2).cYX = 10;
              audw.a(this.this$0.app.getCurrentAccountUin(), (audw.b)localObject2);
              localObject3 = new Intent(this.this$0.getApplicationContext(), FMActivity.class);
              ((Intent)localObject3).putExtra("tab_tab_type", 1);
              localObject2 = localObject3;
              if (this.this$0.cdf)
              {
                audw.JH("0X8005538");
                localObject2 = localObject3;
              }
            }
          }
        case 16: 
          this.this$0.overridePendingTransition(2130772004, 2130772005);
          anot.a(this.this$0.app, "CliOper", "", "", "Weiyun_Backup", "Enter_Backup", 0, 0, "", "", "", "");
          if (((atwc.a)localObject2).Jc != null)
          {
            ((atwc.a)localObject2).Jc.setVisibility(8);
            aute.updateCustomNoteTxt(((atwc.a)localObject2).Jc, 0, 0, 0);
          }
          if (this.this$0.cdf) {
            audw.JH("0X8005536");
          }
          break;
        case 17: 
          QfileFileAssistantActivity.c(this.this$0);
          if (this.this$0.cdf) {
            audw.JH("0X8005535");
          }
          break;
        case 21: 
          audx.b(this.this$0.app, this.this$0, "_is_from_qfile_shortcut", this.this$0.getString(2131693537), 2130845217);
          auds.OT(2131693584);
          ((atwc.a)localObject2).desc.setClickable(false);
          ((atwc.a)localObject2).desc.setOnClickListener(null);
          ((atwc.a)localObject2).desc.setText(this.this$0.getString(2131693583));
          audw.JH("0X8005532");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqt
 * JD-Core Version:    0.7.0.1
 */