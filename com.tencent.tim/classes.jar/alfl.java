import QC.UniBusiGetOneItemWithCheckReq;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleFontItem;
import QC.UniBusiSimpleItemDetail;
import QC.UniBusiSimpleSigItem;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.a;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class alfl
  extends RecyclerView.Adapter<alfl.b>
{
  private UniBusiSimpleItemDetail jdField_a_of_type_QCUniBusiSimpleItemDetail;
  public alfl.a a;
  private StickyNoteShopLayout.a jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$a;
  private URLDrawable.URLDrawableListener jdField_c_of_type_ComTencentImageURLDrawable$URLDrawableListener = new alfr(this);
  private StickyNoteShopLayout jdField_c_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private boolean cwC;
  private int dsO = -1;
  private int dsP = -1;
  private int dsQ;
  private final int dsR = 0;
  private final int dsS = 1;
  private int mAppId;
  private Context mContext;
  private ArrayList<UniBusiSimpleItemDetail> mDataList;
  private Drawable mLoadingDrawable;
  
  public alfl(Context paramContext, ArrayList<UniBusiSimpleItemDetail> paramArrayList)
  {
    this.jdField_a_of_type_Alfl$a = new alfn(this);
    this.mContext = paramContext;
    this.mDataList = paramArrayList;
    this.mLoadingDrawable = paramContext.getResources().getDrawable(2130848024);
  }
  
  private Drawable b(String paramString1, String paramString2)
  {
    Drawable localDrawable = this.mLoadingDrawable;
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      paramString1 = new URL("sig_cover", paramString2, paramString1);
      localObject = localDrawable;
      if (paramString1 != null)
      {
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        localObject = this.mLoadingDrawable;
        paramString2.mFailedDrawable = ((Drawable)localObject);
        paramString2.mLoadingDrawable = ((Drawable)localObject);
        paramString2.mPlayGifImage = true;
        localObject = URLDrawable.getDrawable(paramString1, paramString2);
        ((URLDrawable)localObject).addHeader("my_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        ((URLDrawable)localObject).setURLDrawableListener(this.jdField_c_of_type_ComTencentImageURLDrawable$URLDrawableListener);
      }
      return localObject;
    }
    catch (MalformedURLException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickyNoteVasAdapter", 2, paramString1.getMessage());
        }
        paramString1 = null;
      }
    }
  }
  
  private void f(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str3 = acfp.m(2131706387);
    String str2 = acfp.m(2131721036);
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString2))
    {
      str1 = str2;
      if (paramString2.contains("svip")) {
        str1 = acfp.m(2131721034);
      }
    }
    aqha.a(paramContext, 230, str3, paramString3, acfp.m(2131706388), str1, new alfo(this, paramContext, paramString1, paramString2, paramString4), new alfp(this)).show();
  }
  
  public static boolean kQ(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
    case 1: 
      return true;
    case 4: 
      return VipUtils.cf(localQQAppInterface);
    case 5: 
      return VipUtils.ce(localQQAppInterface);
    }
    return false;
  }
  
  public void F(ArrayList<UniBusiSimpleItemDetail> paramArrayList, boolean paramBoolean)
  {
    int i;
    if ((paramBoolean) && (this.mDataList != null))
    {
      this.mDataList.addAll(paramArrayList);
      notifyDataSetChanged();
      if (this.dsQ != 0) {
        if (this.mDataList != null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < this.mDataList.size())
      {
        if (((UniBusiSimpleItemDetail)this.mDataList.get(i)).itemId == this.dsQ) {
          this.jdField_a_of_type_QCUniBusiSimpleItemDetail = ((UniBusiSimpleItemDetail)this.mDataList.get(i));
        }
      }
      else
      {
        if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail != null)
        {
          this.cwC = true;
          a(this.mAppId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, -1, this.jdField_a_of_type_Alfl$a);
        }
        this.dsQ = 0;
        return;
        this.mDataList = paramArrayList;
        break;
      }
      i += 1;
    }
  }
  
  public int Hv()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  public void SM(int paramInt)
  {
    this.dsQ = paramInt;
    this.dsP = paramInt;
    if (this.jdField_c_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_c_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.NI(false);
    }
  }
  
  public alfl.b a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new alfl.b(View.inflate(paramViewGroup.getContext(), 2131561621, null));
    if (paramInt == 1)
    {
      paramViewGroup.jR.setVisibility(0);
      return paramViewGroup;
    }
    paramViewGroup.jR.setVisibility(8);
    return paramViewGroup;
  }
  
  public Drawable a(Context paramContext, Drawable paramDrawable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramDrawable;
    }
    return new LayerDrawable(new Drawable[] { paramDrawable, paramContext.getResources().getDrawable(2130851309) });
  }
  
  public Drawable a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 14606046;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (!paramString.contains("#")) {
        str = "#" + paramString;
      }
      i = Color.parseColor(str);
    }
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i + 1291845632, i + -2147483648 });
    if (!paramBoolean) {
      return paramString;
    }
    return new LayerDrawable(new Drawable[] { paramString, paramContext.getResources().getDrawable(2130851309) });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, alfl.a parama)
  {
    if ((kQ(paramInt3)) && (parama != null))
    {
      parama.a(true, null);
      return;
    }
    new aqve("QC.UniBusinessUserInfoServer.UniBusinessUserInfoObj", "QcUniBusinessUserInfo.UniBusiGetOneItemWithCheck", "stReq", "stRsp").a("UniBusiGetOneItemWithCheck", new UniBusiGetOneItemWithCheckReq(aqve.a(), paramInt1, paramInt2), new UniBusiGetOneItemWithCheckRsp(), new alfq(this, parama), false);
  }
  
  public void a(alfl.b paramb, int paramInt)
  {
    if ((this.mDataList == null) || (this.mDataList.get(paramInt) == null))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
      return;
    }
    UniBusiSimpleItemDetail localUniBusiSimpleItemDetail = (UniBusiSimpleItemDetail)this.mDataList.get(paramInt);
    paramb.nameTV.setText(localUniBusiSimpleItemDetail.name);
    boolean bool;
    label72:
    int i;
    if (this.dsO == localUniBusiSimpleItemDetail.itemId)
    {
      bool = true;
      if (this.dsP != localUniBusiSimpleItemDetail.itemId) {
        break label308;
      }
      i = 1;
      label86:
      paramb.CE.setVisibility(8);
      if (i != 0)
      {
        i = this.jdField_c_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.dsM;
        localObject = this.jdField_c_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
        if (i == 2) {
          paramb.CE.setVisibility(0);
        }
      }
      QLog.d("StickyNoteVasAdapter", 1, " mAppId:" + this.mAppId);
      if (this.mAppId != 9) {
        break label313;
      }
      paramb.e.setBackgroundDrawable(a(paramb.e.getContext(), localUniBusiSimpleItemDetail.itemBgColor, bool));
      i = (ankt.aE(paramb.itemView.getContext()) - ankt.dip2px(96.0F)) / 3;
      Object localObject = paramb.imageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = ((int)(i * 0.57F));
      paramb.imageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramb.imageView.setImageDrawable(b(String.valueOf(localUniBusiSimpleItemDetail.itemId), localUniBusiSimpleItemDetail.image));
    }
    for (;;)
    {
      f(paramb.nameTV, localUniBusiSimpleItemDetail.feeType);
      paramb.e.setOnClickListener(new alfm(this, localUniBusiSimpleItemDetail));
      break;
      bool = false;
      break label72;
      label308:
      i = 0;
      break label86;
      label313:
      paramb.e.setBackgroundDrawable(a(paramb.e.getContext(), b(String.valueOf(localUniBusiSimpleItemDetail.itemId), localUniBusiSimpleItemDetail.image), bool));
    }
  }
  
  public void a(StickyNoteShopLayout.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$a = parama;
  }
  
  public void b(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    this.jdField_c_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = paramStickyNoteShopLayout;
  }
  
  public void dFA()
  {
    notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$a != null)
    {
      if (this.mAppId != 5) {
        break label60;
      }
      i = 0;
      if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stFontItem != null) {
        i = this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stFontItem.fontType;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$a.setFont(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, i);
    }
    label60:
    while (this.mAppId != 9) {
      return;
    }
    int j = 16777215;
    int i = j;
    if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem != null)
    {
      i = j;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem.fontColor)) {
        i = Color.parseColor(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem.fontColor);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$a.hU(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, i);
  }
  
  public void dFz()
  {
    if ((this.jdField_a_of_type_QCUniBusiSimpleItemDetail != null) && (this.cwC))
    {
      this.cwC = false;
      a(this.mAppId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Alfl$a);
    }
  }
  
  public void f(TextView paramTextView, int paramInt)
  {
    paramTextView.setCompoundDrawablePadding(aqnm.dpToPx(4.0F));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, iH(paramInt), 0);
  }
  
  public int getItemCount()
  {
    if (this.mDataList == null) {}
    for (int i = 0;; i = this.mDataList.size())
    {
      int j = i;
      if (this.jdField_c_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.dsM == 2)
      {
        StickyNoteShopLayout localStickyNoteShopLayout = this.jdField_c_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
        j = Math.min(i, 30);
      }
      return j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public int iH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130848331;
    case 0: 
    case 1: 
      return 2130848330;
    case 4: 
      return 2130848335;
    case 5: 
      return 2130848334;
    case 21: 
      return 2130848333;
    }
    return 2130848332;
  }
  
  public void setAppId(int paramInt)
  {
    this.mAppId = paramInt;
  }
  
  public void setItemId(int paramInt)
  {
    this.dsO = -1;
    if (this.mDataList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mDataList.size())
      {
        if (((UniBusiSimpleItemDetail)this.mDataList.get(i)).itemId == paramInt)
        {
          this.dsO = paramInt;
          this.jdField_a_of_type_QCUniBusiSimpleItemDetail = ((UniBusiSimpleItemDetail)this.mDataList.get(i));
          notifyDataSetChanged();
          return;
        }
        i += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp);
  }
  
  public class b
    extends RecyclerView.ViewHolder
  {
    public ImageView CE;
    public RoundRelativeLayout e;
    public ImageView imageView;
    public LinearLayout jR;
    public TextView nameTV;
    
    public b(View paramView)
    {
      super();
      this.nameTV = ((TextView)paramView.findViewById(2131380814));
      this.imageView = ((ImageView)paramView.findViewById(2131368948));
      this.e = ((RoundRelativeLayout)paramView.findViewById(2131363405));
      this.jR = ((LinearLayout)paramView.findViewById(2131370457));
      this.CE = ((ImageView)paramView.findViewById(2131369076));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfl
 * JD-Core Version:    0.7.0.1
 */