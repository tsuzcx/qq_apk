import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abmf
  extends aqju
  implements Handler.Callback, View.OnClickListener
{
  public TextView KD;
  public TextView PN;
  public TextView PO;
  public TextView PP;
  private aqdf a;
  public String bha;
  public int cpT;
  private int currentState;
  private xxh.b d;
  public int gameId;
  public TextView hW;
  private Handler handler = new auru(this);
  public CornerImageView i;
  public CornerImageView j;
  public RelativeLayout ji;
  private QQAppInterface mApp;
  public TextView mC;
  public Context mContext;
  public View.OnClickListener mListener;
  public TextView mUserName;
  public long roomId;
  public ImageView xs;
  public ImageView xt;
  public ImageView xu;
  
  public abmf(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, 2131755397);
    getWindow().requestFeature(1);
    setCanceledOnTouchOutside(false);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.a = new aqdf(paramQQAppInterface);
    initView();
  }
  
  public void B(View.OnClickListener paramOnClickListener)
  {
    this.mListener = paramOnClickListener;
  }
  
  public void Y(int paramInt, long paramLong)
  {
    this.gameId = paramInt;
    this.roomId = paramLong;
  }
  
  public void a(xxh.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    this.gameId = paramInt1;
    this.cpT = paramInt2;
    this.bha = paramString;
    this.d = paramb;
    this.mUserName.setText(this.mApp.getCurrentNickname());
    this.mC.setText(paramb.nickName);
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mRequestWidth = ((int)jll.dp2px(getContext(), 173.0F));
    paramString.mRequestHeight = ((int)jll.dp2px(getContext(), 97.0F));
    if (paramInt2 == 0)
    {
      this.xs.setVisibility(4);
      this.xt.setVisibility(0);
      paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_fail.png", paramString);
      this.xu.setImageDrawable(paramString);
    }
    for (;;)
    {
      paramString = this.a.a(1, this.mApp.getCurrentUin(), 0, (byte)1);
      this.j.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramString));
      this.i.setImageURL(paramb.aWT);
      setState(0);
      return;
      if (paramInt2 == 1)
      {
        this.xs.setVisibility(0);
        this.xt.setVisibility(4);
        paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_success.png", paramString);
        this.xu.setImageDrawable(paramString);
      }
      else
      {
        this.xs.setVisibility(4);
        this.xt.setVisibility(4);
        paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_draw.png", paramString);
        this.xu.setImageDrawable(paramString);
      }
    }
  }
  
  public void dismiss()
  {
    this.handler.removeCallbacksAndMessages(null);
    super.dismiss();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if (paramMessage.arg1 >= 0) {
          break;
        }
      } while (this.mListener == null);
      this.mListener.onClick(this.PP);
      return true;
      this.PN.setText(paramMessage.arg1 + "s");
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      int k = paramMessage.arg1 - 1;
      paramMessage.arg1 = k;
      localMessage.arg1 = k;
      this.handler.removeMessages(1);
      this.handler.sendMessageDelayed(localMessage, 1000L);
      return true;
    } while (this.mListener == null);
    this.mListener.onClick(this.PP);
    return true;
  }
  
  public void initView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGamePlayAgainDialog", 0, "[initView] init dialog view.");
    }
    View localView = getLayoutInflater().inflate(2131558998, null);
    this.PP = ((TextView)localView.findViewById(2131380606));
    this.xu = ((ImageView)localView.findViewById(2131369881));
    this.ji = ((RelativeLayout)localView.findViewById(2131377422));
    this.PN = ((TextView)localView.findViewById(2131380844));
    this.KD = ((TextView)localView.findViewById(2131380538));
    this.PO = ((TextView)localView.findViewById(2131380890));
    this.j = ((CornerImageView)localView.findViewById(2131369646));
    this.j.setRadius(jll.dp2px(this.mContext, 76.0F));
    this.i = ((CornerImageView)localView.findViewById(2131369648));
    this.i.setRadius(jll.dp2px(this.mContext, 76.0F));
    this.xs = ((ImageView)localView.findViewById(2131369696));
    this.xt = ((ImageView)localView.findViewById(2131369697));
    this.mUserName = ((TextView)localView.findViewById(2131380777));
    this.mC = ((TextView)localView.findViewById(2131380900));
    this.hW = ((TextView)localView.findViewById(2131380647));
    this.PN.setOnClickListener(this);
    this.KD.setOnClickListener(this);
    this.PO.setOnClickListener(this);
    this.PP.setOnClickListener(this);
    this.PP.setTextColor(abmh.b(Color.parseColor("#ffffff"), Color.parseColor("#80ffec00")));
    this.PN.setTextColor(abmh.b(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.KD.setTextColor(abmh.b(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.PO.setTextColor(abmh.b(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.hW.setBackgroundDrawable(new afej(Color.parseColor("#4d000000"), jll.dp2px(this.mContext, 20.0F), (int)jll.dp2px(this.mContext, 250.0F), (int)jll.dp2px(this.mContext, 29.0F)));
    this.PN.setBackgroundDrawable(abmh.a(this.mContext, (int)((float)aqgz.hK() - jll.dp2px(this.mContext, 54.0F)), (int)jll.dp2px(this.mContext, 40.0F), "#000000"));
    this.KD.setBackgroundDrawable(abmh.a(this.mContext, (int)((float)aqgz.hK() - jll.dp2px(this.mContext, 64.0F)) / 2, (int)jll.dp2px(this.mContext, 40.0F), "#000000"));
    this.PO.setBackgroundDrawable(abmh.a(this.mContext, (int)((float)aqgz.hK() - jll.dp2px(this.mContext, 64.0F)) / 2, (int)jll.dp2px(this.mContext, 40.0F), "#3e3f40"));
    setContentView(localView);
    getWindow().setLayout(-1, -1);
    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#9f000000"));
  }
  
  public void onClick(View paramView)
  {
    QLog.e("CmGamePlayAgainDialog", 1, "[onclick] " + paramView.getClass().toString() + ",id:" + paramView.getId());
    if (this.mListener != null) {
      this.mListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (this.mListener != null) {
        this.mListener.onClick(this.PP);
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public String re()
  {
    if (!TextUtils.isEmpty(this.bha)) {
      return ApolloUtil.aI(this.bha, "robotOpenId");
    }
    return null;
  }
  
  public void setState(int paramInt)
  {
    this.currentState = paramInt;
    if (paramInt == 0)
    {
      this.handler.removeMessages(1);
      this.PN.setVisibility(0);
      this.PO.setVisibility(4);
      this.KD.setVisibility(4);
      this.hW.setVisibility(4);
      this.PN.setClickable(true);
      this.PN.setText(acfp.m(2131704122));
      this.PP.setVisibility(0);
      return;
    }
    if (paramInt == 1)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = 30;
      this.handler.sendMessage((Message)localObject);
      this.PN.setClickable(false);
      this.PN.setVisibility(0);
      this.PO.setVisibility(4);
      this.KD.setVisibility(4);
      this.hW.setVisibility(0);
      this.hW.setText(acfp.m(2131704123));
      this.PP.setVisibility(0);
      return;
    }
    this.PN.setVisibility(4);
    this.PO.setVisibility(0);
    this.KD.setVisibility(0);
    if (this.d != null)
    {
      this.hW.setVisibility(0);
      String str = this.d.nickName;
      localObject = str;
      if (!TextUtils.isEmpty(this.d.nickName))
      {
        TextPaint localTextPaint = new TextPaint();
        paramInt = this.d.nickName.length();
        float f = localTextPaint.measureText(this.d.nickName);
        localObject = str;
        while (f > 60.0F)
        {
          localObject = this.d.nickName;
          paramInt -= 1;
          localObject = ((String)localObject).substring(0, paramInt);
          f = localTextPaint.measureText((String)localObject);
        }
        if (paramInt < this.d.nickName.length()) {
          localObject = this.d.nickName.substring(0, paramInt - 1) + "...";
        }
      }
      this.hW.setText((String)localObject + acfp.m(2131704121));
    }
    this.PP.setVisibility(4);
    Object localObject = Message.obtain();
    ((Message)localObject).what = 2;
    this.handler.removeMessages(1);
    this.handler.sendMessageDelayed((Message)localObject, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmf
 * JD-Core Version:    0.7.0.1
 */