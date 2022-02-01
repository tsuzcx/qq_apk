import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class nib
  implements nid
{
  private static Drawable cM;
  private static Drawable cN;
  private KandianMsgBoxRedPntInfo b;
  private View contentView;
  private int i;
  private View mE;
  private ReadInJoyHeadImageView o;
  private View.OnClickListener onClickListener;
  private TextView tl;
  private Activity x;
  
  public nib(Activity paramActivity, View paramView)
  {
    this.x = paramActivity;
    this.contentView = paramView;
    init();
  }
  
  private void init()
  {
    cM = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842559));
    cN = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842560));
    this.contentView.setVisibility(8);
    this.o = ((ReadInJoyHeadImageView)this.contentView.findViewById(2131368698));
    this.o.setRound(true);
    this.o.setImagePlaceHolder(cM);
    this.tl = ((TextView)this.contentView.findViewById(2131365360));
    this.mE = this.contentView.findViewById(2131378554);
    ImageView localImageView = (ImageView)this.contentView.findViewById(2131362995);
    if (localImageView.getDrawable() != null) {
      localImageView.setColorFilter(this.contentView.getResources().getColor(2131165381), PorterDuff.Mode.SRC_IN);
    }
    this.contentView.setOnClickListener(new nic(this));
  }
  
  public void d(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((paramKandianMsgBoxRedPntInfo == null) || (paramKandianMsgBoxRedPntInfo.equals(this.b)))
    {
      QLog.d("ReadinjoySocialMsgTips", 2, "210 msgInfo is null ! " + paramKandianMsgBoxRedPntInfo);
      return;
    }
    QLog.d("ReadinjoySocialMsgTips", 2, "set msg info , count : " + paramKandianMsgBoxRedPntInfo.mMsgCnt + ", uin : " + paramKandianMsgBoxRedPntInfo.mUin + ", seq : " + paramKandianMsgBoxRedPntInfo.mSeq);
    this.i += 1;
    if (this.i % 2 == 0)
    {
      this.o.setImagePlaceHolder(cN);
      this.b = paramKandianMsgBoxRedPntInfo;
      if (this.b.mMsgType != 2) {
        break label239;
      }
      if (TextUtils.isEmpty(this.b.mIconUrl)) {
        break label193;
      }
      this.o.setImage(kxm.b(this.b.mIconUrl));
    }
    for (;;)
    {
      this.b.canDoAnimation = false;
      return;
      this.o.setImagePlaceHolder(cM);
      break;
      label193:
      paramKandianMsgBoxRedPntInfo = (Animatable)this.o.getResources().getDrawable(2130843758);
      this.o.setImageDrawable((Drawable)paramKandianMsgBoxRedPntInfo);
      if (this.b.canDoAnimation)
      {
        paramKandianMsgBoxRedPntInfo.start();
        continue;
        label239:
        if (!TextUtils.isEmpty(this.b.mIconUrl)) {
          this.o.setImage(kxm.b(this.b.mIconUrl));
        } else if (this.b.mUin > 0L) {
          this.o.setHeadImgByUin(this.b.mUin);
        }
      }
    }
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public void onDestroy()
  {
    this.x = null;
    this.o = null;
    this.contentView = null;
    this.tl = null;
    this.onClickListener = null;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
  
  public void show()
  {
    if ((this.contentView != null) && (this.b != null))
    {
      this.contentView.setVisibility(0);
      kbp.a(null, "", "0X800824A", "0X800824A", 0, 0, "", "", "", kxm.iR(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nib
 * JD-Core Version:    0.7.0.1
 */