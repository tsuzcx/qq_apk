import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.b;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;

public class aplv
  extends aplw
{
  private static final String[] hB = { acfp.m(2131713746), acfp.m(2131713745), acfp.m(2131713747) };
  private static final String[] hC = { "https://p.qpic.cn/qqconadmin/0/7af9600e477b4f868fbaa01c879ab2bc/0", "https://p.qpic.cn/qqconadmin/0/a5c9695d3d0c4958b20b505cccf02c55/0", "https://p.qpic.cn/qqconadmin/0/a9fbe3f96d294504811d5c4dc802d02b/0" };
  private static final int[] oK = { 2130844616, 2130844615, 2130844614 };
  private ImageView EC;
  private ImageView ED;
  private ImageView EE;
  private View IE;
  private TextView aaK;
  private TextView aaL;
  private TextView aaR;
  private TextView aaT;
  private TextView aaU;
  private final DecimalFormat e = new DecimalFormat("#.##");
  private TextView wb;
  
  public aplv(View paramView)
  {
    super(paramView);
    this.aaR = ((TextView)paramView.findViewById(2131380880));
    this.IE = paramView.findViewById(2131370628);
    this.aaK = ((TextView)paramView.findViewById(2131380683));
    this.aaL = ((TextView)paramView.findViewById(2131380895));
    this.wb = ((TextView)paramView.findViewById(2131380615));
    this.aaT = ((TextView)paramView.findViewById(2131380879));
    this.EC = ((ImageView)paramView.findViewById(2131369660));
    this.ED = ((ImageView)paramView.findViewById(2131369882));
    this.aaU = ((TextView)paramView.findViewById(2131380878));
    this.EE = ((ImageView)paramView.findViewById(2131366327));
    paramView.setLayerType(1, null);
  }
  
  private void eaB()
  {
    this.EC.setVisibility(0);
    this.aaT.setVisibility(0);
    ((AnimationDrawable)this.EC.getDrawable()).start();
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, HWReciteItem.b paramb)
  {
    paramb = (apkp)paramb.a;
    switch (paramView.getId())
    {
    default: 
    case 2131370628: 
      do
      {
        return;
        if (paramb.mIsPlaying)
        {
          paramHWReciteItem.stopAudio();
          eaC();
          return;
        }
      } while (TextUtils.isEmpty(paramb.mFilePath));
      if (QLog.isColorLevel()) {
        QLog.d("ReciteResultSubViewHolder", 2, new Object[] { "onItemViewClick, play audio, filePath = ", paramb.mFilePath });
      }
      paramHWReciteItem.h(paramb);
      eaB();
      aqfr.b("Grp_edu", "Grp_recite", "Finish_Recite_Play_Clk", 0, 0, new String[] { paramb.mTroopUin });
      return;
    }
    this.ED.setVisibility(8);
    paramHWReciteItem.b(paramb);
  }
  
  public void a(HWReciteItem paramHWReciteItem, HWReciteItem.b paramb, apkp paramapkp, int paramInt)
  {
    this.mItemView.setVisibility(0);
    Object localObject = paramapkp.cpO;
    String str = ReciteFragment.oE((String)localObject);
    if (str.length() > 8) {
      localObject = "《" + str.substring(0, 8) + "…";
    }
    localObject = new StringBuilder(acfp.m(2131713749)).append((String)localObject);
    this.aaR.setText((CharSequence)localObject);
    this.aaK.setText(String.valueOf(paramapkp.clt));
    this.aaL.setText(String.valueOf(paramapkp.dUH));
    this.aaT.setText(String.format("%s\"", new Object[] { this.e.format(paramapkp.arE) }));
    paramInt = paramapkp.dUR - 1;
    if ((paramInt > -1) && (paramInt < oK.length))
    {
      this.wb.setText(hB[paramInt]);
      this.aaU.setText(apit.hA[paramInt].replace("\n", ""));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aqcx.dip2px(BaseApplicationImpl.getContext(), 120.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aqcx.dip2px(BaseApplicationImpl.getContext(), 120.0F);
      localObject = URLDrawable.getDrawable(hC[paramInt], (URLDrawable.URLDrawableOptions)localObject);
      this.EE.setImageDrawable((Drawable)localObject);
    }
    if ((!TextUtils.isEmpty(paramapkp.mFilePath)) && (new File(paramapkp.mFilePath).exists()))
    {
      this.EC.setVisibility(0);
      this.aaT.setVisibility(0);
      if (!paramapkp.mIsPlaying) {
        break label419;
      }
      eaB();
      label317:
      if (paramapkp.mUploadStatus != 2) {
        break label426;
      }
      this.ED.setVisibility(0);
    }
    for (;;)
    {
      paramHWReciteItem.b(this.IE, paramb);
      paramHWReciteItem.b(this.ED, paramb);
      return;
      this.EC.setVisibility(8);
      this.aaT.setVisibility(8);
      if ((TextUtils.isEmpty(paramapkp.bIS)) || (paramapkp.mDownloadStatus != 0)) {
        break;
      }
      paramHWReciteItem.g(paramapkp);
      if (paramapkp.mDownloadStatus != 2) {
        break;
      }
      this.EC.setVisibility(0);
      this.aaT.setVisibility(0);
      break;
      label419:
      eaC();
      break label317;
      label426:
      this.ED.setVisibility(8);
    }
  }
  
  public void eaC()
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.EC.getDrawable();
    localAnimationDrawable.stop();
    localAnimationDrawable.selectDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplv
 * JD-Core Version:    0.7.0.1
 */