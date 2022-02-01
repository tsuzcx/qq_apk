import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zmd
  extends zkv
{
  public zmd(Context paramContext, aurf paramaurf, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramaurf, paramSessionInfo, paramQQAppInterface);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    zmc localzmc = (zmc)getItem(paramInt);
    View localView;
    zkv.a locala;
    MessageRecord localMessageRecord;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, 2131559542, null);
      locala = new zkv.a();
      locala.c = ((ColorNickTextView)localView.findViewById(2131379402));
      locala.KQ = ((TextView)localView.findViewById(2131379404));
      locala.icon = ((ImageView)localView.findViewById(2131368698));
      locala.time = ((TextView)localView.findViewById(2131370129));
      localView.setTag(locala);
      localMessageRecord = localzmc.messageRecord;
      paramView = aqpm.a(localMessageRecord.msg, localMessageRecord, 32, 3);
      locala.KQ.setText(paramView);
      localObject = localMessageRecord.senderuin;
      paramView = (View)localObject;
      if (this.mSessionInfo.cZ != 1)
      {
        paramView = (View)localObject;
        if (this.mSessionInfo.cZ != 3000) {
          if (!localMessageRecord.isSend()) {
            break label308;
          }
        }
      }
    }
    label308:
    for (paramView = this.app.getCurrentAccountUin();; paramView = this.mSessionInfo.aTl)
    {
      if (!jof.a(localMessageRecord)) {
        break label319;
      }
      paramView = jof.a(localMessageRecord);
      locala.c.setText(this.mContext.getResources().getString(2131699453) + paramView.TG);
      locala.icon.setBackgroundDrawable(URLDrawable.getDrawable(jof.aV(paramView.aCv)));
      locala.time.setText(localzmc.be(localMessageRecord.time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      locala = (zkv.a)paramView.getTag();
      localView = paramView;
      break;
    }
    label319:
    Object localObject = apsb.a(localMessageRecord);
    if (localObject != null)
    {
      paramView = ((apsb.a)localObject).nickname;
      Drawable localDrawable = this.mContext.getResources().getDrawable(2130840645);
      localObject = URLDrawable.getDrawable(((apsb.a)localObject).headUrl, localDrawable, localDrawable);
      ((URLDrawable)localObject).setTag(aqbn.d(100, 100, 6));
      ((URLDrawable)localObject).setDecodeHandler(aqbn.b);
      locala.icon.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView = new aofe(paramView, 32).k();
      locala.c.setText(paramView);
      aqpm.a(this.app, locala.c, paramView);
      break;
      localObject = aqgv.a(this.app, this.mSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      locala.icon.setBackgroundDrawable(aqdj.a(this.app, 1, paramView));
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmd
 * JD-Core Version:    0.7.0.1
 */