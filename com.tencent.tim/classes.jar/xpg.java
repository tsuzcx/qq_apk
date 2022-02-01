import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class xpg
  extends wjd
{
  public static int bVS = 1;
  aquy jdField_a_of_type_Aquy = new xpj(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private aqva jdField_a_of_type_Aqva;
  Handler mHandler = new xph(this, Looper.getMainLooper());
  
  public xpg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Aqva = ((aqva)paramQQAppInterface.getManager(47));
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramwlz = (xpg.a)parama;
    int i = 0;
    parama = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(parama)) {
        i = Integer.parseInt(parama);
      }
      parama = paramView;
      if (paramView == null)
      {
        parama = LayoutInflater.from(this.mContext).inflate(2131558899, null);
        paramwlz.e = ((AnyScaleTypeImageView)parama.findViewById(2131364919));
        paramwlz.JV = ((TextView)parama.findViewById(2131364922));
        paramwlz.dr = ((ViewGroup)parama.findViewById(2131364918));
        paramwlz.dr.setOnClickListener(new xpi(this, i));
      }
      str = aqgv.o(this.app, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = aqwu.a(this.app, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!aqhq.fileExists(paramView)) {}
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramwlz.e.setImageBitmap(BitmapFactory.decodeFile(paramView));
          paramView = paramMessageRecord.getExtInfoFromExtStr("name");
          if (!TextUtils.isEmpty(paramView)) {
            j = 2;
          }
          try
          {
            paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("tipsType");
            i = j;
            if (!TextUtils.isEmpty(paramMessageRecord)) {
              i = Integer.parseInt(paramMessageRecord);
            }
          }
          catch (Exception paramMessageRecord)
          {
            QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView tipsType err:" + paramMessageRecord.getMessage());
            i = j;
            continue;
            paramwlz.JV.setText(str + acfp.m(2131715322) + this.mContext.getString(2131691749, new Object[] { paramView }));
            return parama;
          }
          if (2 != i) {
            break;
          }
          paramwlz.JV.setText(str + acfp.m(2131715321) + this.mContext.getString(2131691749, new Object[] { paramView }));
          return parama;
          parama = parama;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + parama.getMessage());
          i = 0;
        }
        catch (OutOfMemoryError paramView)
        {
          QLog.e("ChatItemBuilder", 1, "decodeFile funcall thum Bitmap OOM.");
          continue;
        }
        catch (Exception paramView)
        {
          QLog.e("ChatItemBuilder", 1, "colorRingCover err:" + paramView.getMessage());
          continue;
        }
        paramwlz.e.setImageDrawable(this.mContext.getResources().getDrawable(2130847953));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = aqwu.b(this.app, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new aquz(paramView, localFile);
        this.jdField_a_of_type_Aqva.a(1).a(paramView, this.jdField_a_of_type_Aquy, paramLinearLayout);
      }
    }
    paramwlz.e.setImageDrawable(this.mContext.getResources().getDrawable(2130847953));
    paramwlz.JV.setText(str + this.mContext.getString(2131691749, new Object[] { this.mContext.getResources().getString(2131691236) }));
    return parama;
  }
  
  protected wjd.a a()
  {
    return new xpg.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return new aqob[0];
  }
  
  public void refresh()
  {
    this.adapter.notifyDataSetChanged();
  }
  
  class a
    extends wjd.a
  {
    public TextView JV;
    public ViewGroup dr;
    public AnyScaleTypeImageView e;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpg
 * JD-Core Version:    0.7.0.1
 */