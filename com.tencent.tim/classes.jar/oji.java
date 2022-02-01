import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stVideoTag;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;

public class oji
  extends auwn<stSimpleMetaFeed>
  implements View.OnClickListener, ojh.a
{
  private static final int bfg = oor.j(5.0F);
  private static final int bfh = oor.j(10.0F);
  private static long yQ;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private ofv jdField_a_of_type_Ofv;
  private ojj.a jdField_a_of_type_Ojj$a;
  private ojk jdField_a_of_type_Ojk;
  private KandianUrlImageView aa;
  private RoundImageView c;
  private stSimpleMetaFeed jdField_d_of_type_UserGrowthStSimpleMetaFeed;
  private RoundImageView jdField_d_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private RelativeLayout fF;
  private RelativeLayout fG;
  private Context mContext;
  private TextView uI;
  private TextView uJ;
  private TextView uK;
  private TextView uL;
  private TextView uM;
  private TextView uQ;
  private TextView uR;
  private TextView uS;
  private TextView uT;
  private TextView uU;
  private TextView ux;
  
  private oji(ViewGroup paramViewGroup, ofv paramofv, int paramInt)
  {
    super(paramViewGroup, 2131560585);
    this.jdField_a_of_type_Ojj$a = ojj.a(paramInt);
    this.mContext = getContext();
    this.jdField_a_of_type_Ofv = paramofv;
    this.jdField_a_of_type_Ojk = new ojk(this);
    initView();
    this.itemView.setOnClickListener(this);
  }
  
  public static oji a(ViewGroup paramViewGroup, ofv paramofv, int paramInt)
  {
    return new oji(paramViewGroup, paramofv, paramInt);
  }
  
  private void bfl()
  {
    int j = 0;
    int i;
    if (oor.isDebug())
    {
      if (ojj.em(oor.bfy))
      {
        i = oor.bfy;
        this.jdField_a_of_type_Ojj$a = ojj.a(i);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Ojj$a.axw) {
        break label119;
      }
      this.fF.setVisibility(0);
      this.fG.setVisibility(8);
      qN(true);
      label61:
      if (TextUtils.isEmpty(this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.feed_desc)) {
        break label201;
      }
      if (!this.jdField_a_of_type_Ojj$a.axt) {
        break label190;
      }
      i = 8;
      label87:
      if (!this.jdField_a_of_type_Ojj$a.axt) {
        break label195;
      }
    }
    for (;;)
    {
      this.uK.setVisibility(i);
      this.uL.setVisibility(j);
      return;
      i = 1;
      break;
      label119:
      if (this.jdField_a_of_type_Ojj$a.axx)
      {
        this.fF.setVisibility(8);
        this.fG.setVisibility(0);
        qN(false);
        break label61;
      }
      oor.a(0, new View[] { this.fF, this.fG });
      qN(this.jdField_a_of_type_Ojj$a.axu);
      break label61;
      label190:
      i = 0;
      break label87;
      label195:
      j = 8;
    }
    label201:
    oor.a(8, new View[] { this.uK, this.uL });
  }
  
  private void bfm()
  {
    if (this.fG.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(bfg);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(bfg, 1);
  }
  
  private void bfn()
  {
    stH5OpInfo localstH5OpInfo = this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.h5_op_info;
    StringBuilder localStringBuilder = new StringBuilder().append("title = ").append(this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.feed_desc).append(", feedId = ").append(this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.id).append(", posterId = ").append(this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.poster_id).append(", video_type = ").append(this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.video_type).append(", h5OpInfo.type = ");
    if (localstH5OpInfo != null)
    {
      localObject = Integer.valueOf(localstH5OpInfo.type);
      localStringBuilder = localStringBuilder.append(localObject).append(", h5OpInfo.maskImgUrl = ");
      if (localstH5OpInfo == null) {
        break label238;
      }
    }
    label238:
    for (Object localObject = localstH5OpInfo.maskImgUrl;; localObject = "null")
    {
      ooz.i("WSGridCardHolder", (String)localObject + ", cardType = " + this.jdField_a_of_type_Ojj$a.toString());
      if (this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.video_type != 1) {
        break label255;
      }
      if ((localstH5OpInfo != null) && (localstH5OpInfo.type == 2)) {
        oor.a(8, new View[] { this.fF, this.fG });
      }
      if ((ohy.a().rp() != 2) || (localstH5OpInfo == null) || (TextUtils.isEmpty(localstH5OpInfo.maskImgUrl))) {
        break label245;
      }
      this.aa.setVisibility(0);
      opn.a(this.aa, localstH5OpInfo.maskImgUrl);
      return;
      localObject = "null";
      break;
    }
    label245:
    this.aa.setVisibility(8);
    return;
    label255:
    this.aa.setVisibility(8);
  }
  
  private void bfo()
  {
    if (this.jdField_a_of_type_Ojj$a.cardType == 10) {
      oor.a(8, new View[] { this.fF, this.fG });
    }
  }
  
  private void bfp()
  {
    float f2 = 1.333333F;
    Object localObject = this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.waterFallCardStyle;
    boolean bool;
    float f1;
    label58:
    label66:
    label75:
    int i;
    if ((localObject != null) && (((stWaterFallCardStyle)localObject).isFullSpan))
    {
      bool = true;
      if ((localObject == null) || (((stWaterFallCardStyle)localObject).ratioW == 0)) {
        break label157;
      }
      f1 = ((stWaterFallCardStyle)localObject).ratioH * 1.0F / ((stWaterFallCardStyle)localObject).ratioW;
      if (f1 <= 2.0F) {
        break label164;
      }
      f1 = f2;
      if (!bool) {
        break label167;
      }
      f1 = 0.5625F;
      ((StaggeredGridLayoutManager.LayoutParams)this.itemView.getLayoutParams()).setFullSpan(bool);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.getLayoutParams();
      i = opm.getScreenWidth();
      if (!bool) {
        break label170;
      }
      i -= ofp.SPACE * 2;
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(f1 * i));
      opn.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, this.jdField_d_of_type_UserGrowthStSimpleMetaFeed, oor.getDrawable(2131165905), "feeds", true);
      return;
      bool = false;
      break;
      label157:
      f1 = 1.333333F;
      break label58;
      label164:
      break label66;
      label167:
      break label75;
      label170:
      i = (i - ofp.SPACE * 3) / 2;
    }
  }
  
  private void bfq()
  {
    stVideoTag localstVideoTag = this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.videoTag;
    if ((localstVideoTag == null) || (TextUtils.isEmpty(localstVideoTag.text)))
    {
      this.ux.setVisibility(8);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((!TextUtils.isEmpty(localstVideoTag.textColor)) && (localstVideoTag.textColor.startsWith("#")))
    {
      localObject1 = localstVideoTag.textColor;
      if ((TextUtils.isEmpty(localstVideoTag.bgColor)) || (!localstVideoTag.bgColor.startsWith("#"))) {
        break label251;
      }
      localObject2 = localstVideoTag.bgColor;
      label88:
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(opm.bfC);
      if (!opm.eI((String)localObject2)) {
        break label278;
      }
      label113:
      localGradientDrawable.setColor(Color.parseColor((String)localObject2));
      this.ux.setText(localstVideoTag.text);
      localObject2 = this.ux;
      if (!opm.eI((String)localObject1)) {
        break label285;
      }
      label145:
      ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      this.ux.setBackgroundDrawable(localGradientDrawable);
      this.ux.setVisibility(0);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      if (this.fF.getVisibility() == 0) {
        break label292;
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131369493);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(bfh, 0, bfh, bfh);
    }
    for (;;)
    {
      this.ux.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
      localObject1 = "#" + localstVideoTag.textColor;
      break;
      label251:
      localObject2 = "#" + localstVideoTag.bgColor;
      break label88;
      label278:
      localObject2 = "#80000000";
      break label113;
      label285:
      localObject1 = "#FFFFFF";
      break label145;
      label292:
      ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131369495);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(bfh, 0, bfh, bfh / 2);
    }
  }
  
  private void bfr()
  {
    String str = this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.feed_desc;
    if (this.uK.getVisibility() == 0) {
      this.uK.setText(str);
    }
    while (this.uL.getVisibility() != 0) {
      return;
    }
    this.uL.setText(str);
  }
  
  private void bfs()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.poster;
    if ((localstSimpleMetaPerson == null) || (this.jdField_a_of_type_Ojj$a.axv))
    {
      this.uI.setVisibility(8);
      return;
    }
    boolean bool;
    label122:
    TextView localTextView;
    if (this.c.getVisibility() == 0)
    {
      bool = true;
      ooz.d("WSGridCardHolder", "inner: " + bool + ", nick: " + localstSimpleMetaPerson.nick + ", medal: " + localstSimpleMetaPerson.medal + ", avatar: " + localstSimpleMetaPerson.avatar);
      if (!bool) {
        break label181;
      }
      localObject = this.c;
      if (!bool) {
        break label189;
      }
      localTextView = this.uM;
      label131:
      opn.a(this.mContext, (RoundImageView)localObject, localstSimpleMetaPerson.avatar);
      localTextView.setText(oor.fy(localstSimpleMetaPerson.nick));
      if (!bool) {
        break label197;
      }
    }
    label181:
    label189:
    label197:
    for (Object localObject = this.uI;; localObject = this.uJ)
    {
      oor.a((TextView)localObject, localstSimpleMetaPerson.medal, false);
      return;
      bool = false;
      break;
      localObject = this.jdField_d_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
      break label122;
      localTextView = this.uQ;
      break label131;
    }
  }
  
  private void bft()
  {
    int i = 2130843984;
    int k;
    label63:
    label67:
    label75:
    TextView localTextView1;
    label85:
    TextView localTextView2;
    if (this.uR.getVisibility() == 0)
    {
      k = 1;
      if (this.jdField_a_of_type_Ojj$a.axv)
      {
        if ((this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.playNum > 0) || (k == 0)) {
          break label156;
        }
        oor.a(8, new View[] { this.c, this.uM });
      }
      if (k == 0) {
        break label211;
      }
      if (k == 0) {
        break label218;
      }
      j = 2130847545;
      if (k == 0) {
        break label225;
      }
      localTextView1 = this.uR;
      if (k == 0) {
        break label234;
      }
      localTextView2 = this.uT;
      label95:
      if (!this.jdField_a_of_type_Ojj$a.axy) {
        break label243;
      }
      label105:
      if (!this.jdField_a_of_type_Ojj$a.axy) {
        break label248;
      }
    }
    label156:
    label211:
    label218:
    label225:
    label234:
    label243:
    label248:
    for (int j = this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.playNum;; j = this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.ding_count)
    {
      if ((j > 0) || (k == 0)) {
        break label259;
      }
      oor.a(8, new View[] { localTextView1, localTextView2 });
      return;
      k = 0;
      break;
      oor.a(0, new View[] { this.c, this.uM });
      this.c.setImageDrawable(oor.getDrawable(2130843984));
      muj.a(this.uM, this.jdField_d_of_type_UserGrowthStSimpleMetaFeed.playNum, "0");
      break label63;
      i = 2130851949;
      break label67;
      j = 2130851948;
      break label75;
      localTextView1 = this.uS;
      break label85;
      localTextView2 = this.uU;
      break label95;
      i = j;
      break label105;
    }
    label259:
    oor.a(0, new View[] { localTextView1, localTextView2 });
    localTextView1.setBackgroundResource(i);
    muj.a(localTextView2, j, "0");
  }
  
  private void initView()
  {
    this.fF = ((RelativeLayout)getView(2131369495));
    this.fG = ((RelativeLayout)getView(2131369496));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)getView(2131369493));
    this.aa = ((KandianUrlImageView)getView(2131369497));
    this.ux = ((TextView)getView(2131369502));
    this.c = ((RoundImageView)this.fF.findViewById(2131369491));
    this.jdField_d_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.fG.findViewById(2131369491));
    this.uI = ((TextView)this.fF.findViewById(2131369498));
    this.uJ = ((TextView)this.fG.findViewById(2131369498));
    this.uK = ((TextView)this.fF.findViewById(2131369494));
    this.uL = ((TextView)this.fG.findViewById(2131369494));
    this.uM = ((TextView)this.fF.findViewById(2131369499));
    this.uQ = ((TextView)this.fG.findViewById(2131369499));
    this.uR = ((TextView)this.fF.findViewById(2131369501));
    this.uS = ((TextView)this.fG.findViewById(2131369501));
    this.uT = ((TextView)this.fF.findViewById(2131369500));
    this.uU = ((TextView)this.fG.findViewById(2131369500));
  }
  
  private void qN(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      oor.a(i, new View[] { this.c, this.uI, this.uM, this.uR, this.uT });
      return;
    }
  }
  
  public ofv a()
  {
    return this.jdField_a_of_type_Ofv;
  }
  
  public void d(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    super.P(paramstSimpleMetaFeed);
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    this.jdField_d_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    bfl();
    bfp();
    bfr();
    bfq();
    bfs();
    bft();
    bfn();
    bfo();
    bfm();
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - yQ < 800L) {
      ooz.i("WSGridCardHolder", "fast click, ignored: recommend item view");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yQ = System.currentTimeMillis();
      int i = getAdapterPosition() - ((auwz)this.jdField_a_of_type_Ofv.a.getAdapter()).rl();
      ooz.d("WSGridCardHolder", "onClick: " + i);
      ArrayList localArrayList = new ArrayList();
      if ((i >= this.jdField_a_of_type_Ofv.Pb()) || (i < 0))
      {
        ooz.e("WSGridCardHolder", "position out of bound");
      }
      else
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Ofv.getItem(i);
        if (localstSimpleMetaFeed == null)
        {
          ooz.e("WSGridCardHolder", "feed is null");
        }
        else
        {
          ong.n(112, ong.a(i, localstSimpleMetaFeed));
          opa.bfY();
          if (localstSimpleMetaFeed.video_type == 1)
          {
            this.jdField_a_of_type_Ojk.a(this.mContext, localstSimpleMetaFeed, i);
            ooz.d("WSGridCardHolder", "点击了运营图片");
          }
          else if (localstSimpleMetaFeed.video_type == 6)
          {
            this.jdField_a_of_type_Ojk.a(this.mContext, i, localstSimpleMetaFeed);
          }
          else
          {
            ond.b(localstSimpleMetaFeed, i, 112);
            if (!this.jdField_a_of_type_Ojk.a(this.mContext, i, localArrayList, localstSimpleMetaFeed))
            {
              this.jdField_a_of_type_Ojk.a(this.mContext, i, localArrayList, localstSimpleMetaFeed);
              WSPublicAccReport.getInstance().feedsItemReport("gzh_click", opn.getSceneTypeTestId(1), localstSimpleMetaFeed, ond.a(localstSimpleMetaFeed, i), 1000001);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oji
 * JD-Core Version:    0.7.0.1
 */