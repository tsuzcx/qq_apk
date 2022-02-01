import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arfx
  extends aqju
  implements View.OnClickListener
{
  TextView abX;
  QQAppInterface app;
  Button cE;
  String content;
  TextView jdField_do;
  String jumpUrl;
  Context mContext;
  View mRoot;
  View qi;
  
  public arfx(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, 2131756467);
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    this.content = paramString1;
    this.jumpUrl = paramString2;
    initUI();
  }
  
  public void initUI()
  {
    this.mRoot = LayoutInflater.from(this.mContext).inflate(2131561379, null);
    this.qi = this.mRoot.findViewById(2131379823);
    this.qi.setOnClickListener(this);
    this.abX = ((TextView)this.mRoot.findViewById(2131379831));
    this.abX.setOnClickListener(this);
    if (TextUtils.isEmpty(this.jumpUrl)) {
      this.abX.setVisibility(8);
    }
    this.jdField_do = ((TextView)this.mRoot.findViewById(2131365395));
    this.jdField_do.setText(this.content);
    this.cE = ((Button)this.mRoot.findViewById(2131364687));
    this.cE.setOnClickListener(this);
    this.cE.setContentDescription(this.mContext.getString(2131699844));
    setContentView(this.mRoot);
    setCancelable(true);
    Object localObject = this.mContext.getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = this.mRoot.getLayoutParams();
    localLayoutParams.width = ((int)(((DisplayMetrics)localObject).widthPixels - aqho.convertDpToPixel(this.mContext, 30.0F)));
    this.mRoot.setLayoutParams(localLayoutParams);
    localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).gravity = 48;
    ((WindowManager.LayoutParams)localObject).y = ((int)aqho.convertDpToPixel(this.mContext, 10.0F) + wja.dp2px(50.0F, this.mContext.getResources()));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
      continue;
      Object localObject = aqik.c(this.app, this.mContext, this.jumpUrl);
      if (localObject != null)
      {
        ((aqhv)localObject).ace();
      }
      else
      {
        localObject = new Intent(this.mContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jumpUrl);
        this.mContext.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfx
 * JD-Core Version:    0.7.0.1
 */