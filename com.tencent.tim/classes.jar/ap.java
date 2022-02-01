import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.app.MobileQQ;

public class ap
  implements View.OnClickListener
{
  public ap(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, DataLineMsgSet paramDataLineMsgSet, Context paramContext, int paramInt, String paramString, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    int i;
    if (2131365456 == paramView.getId())
    {
      anpb.F(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_copy");
      ((ClipboardManager)this.this$0.mListView.getContext().getSystemService("clipboard")).setText(this.a.msg);
      i = LiteActivity.a(this.this$0);
      anot.a(this.this$0.app, "dc00898", "", "", "0X800AD63", "0X800AD63", 1, 0, "" + i, "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1;
      Object localObject2;
      int j;
      if (2131365692 == paramView.getId())
      {
        anpb.F(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_delete");
        localObject1 = new aq(this);
        localObject2 = new ar(this);
        aqha.a(this.val$context, 230, this.val$context.getString(2131695407), this.val$context.getString(2131695391), 2131721058, 2131695421, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
        i = LiteActivity.a(this.this$0, this.a, this.cY);
        j = LiteActivity.a(this.this$0);
        anot.a(this.this$0.app, "dc00898", "", "", "0X800AD5D", "0X800AD5D", i, 0, "" + j, "", "", "");
      }
      else
      {
        if (2131367523 == paramView.getId())
        {
          anpb.F(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_forward");
          if (this.cY == -1000)
          {
            localObject1 = this.a;
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("forward_text", new aofk(((DataLineMsgRecord)localObject1).msg, 13, 32, 6000).toString());
            ((Intent)localObject2).putExtra("forward_type", -1);
            ((Intent)localObject2).putExtra("isFromShare", true);
            ((Intent)localObject2).putExtra("isFromDataLineAIO", true);
            ahgq.f(this.this$0, (Intent)localObject2, 4);
          }
          for (;;)
          {
            i = LiteActivity.a(this.this$0, this.a, this.cY);
            j = LiteActivity.a(this.this$0);
            anot.a(this.this$0.app, "dc00898", "", "", "0X800AD5B", "0X800AD5B", i, 0, "" + j, "", "", "");
            break;
            if (aqhq.fileExistsAndNotEmpty(this.aW))
            {
              long l = aqhq.getFileSizes(this.aW);
              localObject1 = ahav.getFileName(this.aW);
              localObject2 = new ForwardFileInfo();
              ((ForwardFileInfo)localObject2).setType(10000);
              ((ForwardFileInfo)localObject2).Oj(6);
              ((ForwardFileInfo)localObject2).setFileName((String)localObject1);
              ((ForwardFileInfo)localObject2).setFileSize(l);
              if ((this.a != null) && (!TextUtils.isEmpty(this.a.thumbPath))) {
                ((ForwardFileInfo)localObject2).aA(this.a.thumbPath);
              }
              ((ForwardFileInfo)localObject2).setLocalPath(this.aW);
              if (this.a != null) {
                ((ForwardFileInfo)localObject2).p(this.a.entityID);
              }
              Intent localIntent = new Intent();
              if (this.aX)
              {
                label643:
                localIntent.putExtra("forward_text", (String)localObject1);
                if (!this.aX) {
                  break label811;
                }
                i = 1;
                label662:
                localIntent.putExtra("forward_type", i);
                localIntent.putExtra("forward_filepath", this.aW);
                localIntent.putExtra("fileinfo", (Parcelable)localObject2);
                localIntent.putExtra("not_forward", true);
                localIntent.putExtra("isFromShare", true);
                localIntent.putExtra("isFromDataLineAIO", true);
                if (!this.aX) {
                  break label816;
                }
                localIntent.putExtra("forward_thumb", this.a.path);
              }
              for (;;)
              {
                ahgq.f(this.this$0, localIntent, 4);
                break;
                localObject1 = acfp.m(2131707825) + (String)localObject1 + acfp.m(2131707823) + ahbj.g(l) + "。";
                break label643;
                label811:
                i = 0;
                break label662;
                label816:
                localIntent.putExtra("k_favorites", false);
              }
            }
            ahav.a(ahav.a(this.a), this.this$0.app, this.this$0, 10009);
          }
        }
        if (2131366733 == paramView.getId())
        {
          if (this.aW.isEmpty())
          {
            aviz.a(null, this.a.msg).a(this.this$0.app).b(this.this$0.getActivity(), this.this$0.app.getAccount());
            avjg.a(this.this$0.app, 64, 1);
          }
          for (;;)
          {
            i = LiteActivity.a(this.this$0, this.a, this.cY);
            j = LiteActivity.a(this.this$0);
            anot.a(this.this$0.app, "dc00898", "", "", "0X800AD5C", "0X800AD5C", i, 0, "" + j, "", "", "");
            break;
            if (this.cY == -2000)
            {
              aviz.b(this.aW).a(this.this$0.app).b(this.this$0.getActivity(), this.this$0.app.getAccount());
              avjg.a(this.this$0.app, 64, 3);
            }
            else if ((this.cY == -2005) || (this.cY == -2009))
            {
              new aviz(3).b(this.this$0.app, this.this$0, this.aW);
            }
          }
        }
        if (2131381353 == paramView.getId())
        {
          LiteActivity.a(this.this$0, this.a, this.cY, this.aW);
        }
        else if (2131362240 == paramView.getId())
        {
          LiteActivity.a(this.this$0, this.b, this.a, this.cY);
        }
        else if (2131379277 == paramView.getId())
        {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
          localObject1 = new TeamWorkFileImportInfo();
          ((TeamWorkFileImportInfo)localObject1).filePath = this.a.path;
          ((TeamWorkFileImportInfo)localObject1).fileName = this.a.filename;
          ((TeamWorkFileImportInfo)localObject1).nFileType = ahav.getFileType(this.a.filename);
          ((TeamWorkFileImportInfo)localObject1).peerType = this.this$0.sessionInfo.cZ;
          ((TeamWorkFileImportInfo)localObject1).peerUin = this.this$0.sessionInfo.aTl;
          ((TeamWorkFileImportInfo)localObject1).dNQ = 1;
          ((TeamWorkFileImportInfo)localObject1).fileSize = this.a.filesize;
          aoag.a((TeamWorkFileImportInfo)localObject1, this.val$context, this.this$0.app, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ap
 * JD-Core Version:    0.7.0.1
 */