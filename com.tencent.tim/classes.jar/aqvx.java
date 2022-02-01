import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.a;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.vip.diy.template.ProfileCardDiyPhotoWallView;
import com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplateBase;
import com.tencent.mobileqq.vip.diy.template.TemplatePhotoWall;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.mobileqq.widget.PhotoWallView.b;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqvx
{
  protected View Jd;
  protected aqvx.c a;
  protected String bWn = "";
  protected alcn c;
  protected JSONObject cc;
  protected String cyg;
  protected String cyh;
  protected String cyi;
  protected String cyj;
  protected String cyk;
  protected int edj;
  protected int gW = -1;
  protected Activity mActivity;
  protected int mBorderWidth;
  protected int mColor = -1;
  protected LayoutInflater mInflater;
  
  public aqvx(Activity paramActivity, JSONObject paramJSONObject, alcn paramalcn)
  {
    this.mActivity = paramActivity;
    this.cc = paramJSONObject;
    this.c = paramalcn;
    this.mInflater = LayoutInflater.from(paramActivity);
    try
    {
      this.mColor = Color.parseColor(paramJSONObject.optString("c"));
      this.cyg = paramJSONObject.optString("sbg");
      this.cyh = paramJSONObject.optString("t_bg");
      this.cyi = paramJSONObject.optString("arr");
      this.cyj = paramJSONObject.optString("f");
      this.cyk = paramJSONObject.optString("cbg", "");
      this.edj = paramJSONObject.optInt("cpd", 0);
      this.a = new aqvx.c();
    }
    catch (IllegalArgumentException paramActivity)
    {
      for (;;)
      {
        try
        {
          this.gW = Color.parseColor(paramJSONObject.optString("line"));
          return;
        }
        catch (IllegalArgumentException paramActivity)
        {
          rom.fail("DIYProfileTemplate.ProfileTemplateBase default line color is illegal! " + paramJSONObject.optString("c"), new Object[0]);
          this.gW = -1;
        }
        paramActivity = paramActivity;
        rom.fail("DIYProfileTemplate.ProfileTemplateBase default main color is illegal! " + paramJSONObject.optString("c"), new Object[0]);
        this.mColor = -16777216;
      }
    }
  }
  
  private JSONObject a(Map<String, JSONObject> paramMap, String paramString)
  {
    JSONObject localJSONObject = (JSONObject)paramMap.get(paramString);
    paramMap = localJSONObject;
    if (localJSONObject == null) {
      ram.e("DIYProfileTemplate.ProfileTemplateBase", ":json illegal : it don't have " + paramString + " module");
    }
    try
    {
      paramMap = new JSONObject("{}");
      return paramMap;
    }
    catch (JSONException paramMap)
    {
      rom.fail("DIYProfileTemplate.ProfileTemplateBase:json error : it can not generate default " + paramString + " module", new Object[0]);
    }
    return null;
  }
  
  private void cZ(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(rpq.getScreenWidth(this.mActivity) - rpq.dip2px(this.mActivity, 30.0F), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  public void N(HashMap<String, View> paramHashMap)
  {
    this.Jd = this.mInflater.inflate(2131562212, null);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Jd.getLayoutParams();
    Object localObject = localMarginLayoutParams;
    if (localMarginLayoutParams == null) {
      localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    }
    ((ViewGroup.MarginLayoutParams)localObject).setMargins(dip2px(11.0F), dip2px(11.0F), dip2px(11.0F), dip2px(11.0F));
    this.Jd.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramHashMap.put("map_key_account_base_info", this.Jd);
    localObject = this.Jd.findViewById(2131374950);
    ((View)localObject).setBackgroundResource(2130839684);
    paramHashMap.put("map_key_sig", localObject);
    localObject = this.Jd.findViewById(2131374952);
    ((View)localObject).setBackgroundResource(2130839684);
    paramHashMap.put("map_key_account_level_info", localObject);
    ((View)localObject).setClickable(false);
    localObject = this.Jd.findViewById(2131374948);
    ((View)localObject).setBackgroundResource(2130839684);
    paramHashMap.put("map_key_medal_and_diamond", localObject);
  }
  
  public void O(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.mInflater.inflate(2131562213, null));
  }
  
  public void VL(String paramString)
  {
    this.bWn = paramString;
  }
  
  public View a(ETTextView paramETTextView)
  {
    paramETTextView.setTextColor(this.mColor);
    return paramETTextView;
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    QZoneLayoutTemplateBase localQZoneLayoutTemplateBase = (QZoneLayoutTemplateBase)paramView.findViewById(2131369207);
    localQZoneLayoutTemplateBase.setBorderColor(g(paramJSONObject));
    localQZoneLayoutTemplateBase.setBorderWidth(h(paramJSONObject));
    localQZoneLayoutTemplateBase.setItemBg(a(paramJSONObject, dip2px(70.0F), dip2px(70.0F)));
    a(paramJSONObject, paramView.findViewById(2131368698), (TextView)paramView.findViewById(2131379562), (ImageView)paramView.findViewById(2131368865));
    return paramView;
  }
  
  public View a(JSONObject paramJSONObject, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7)
  {
    ViewGroup localViewGroup = (ViewGroup)this.Jd.findViewById(2131361884);
    Object localObject;
    if (paramView1 == null)
    {
      localObject = localViewGroup.findViewById(2131361887);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localViewGroup.setVisibility(8);
      if (paramView2 != null) {
        break label518;
      }
      this.Jd.findViewById(2131374950).setVisibility(8);
      label66:
      if (paramView3 != null) {
        break label536;
      }
      this.Jd.findViewById(2131374952).setVisibility(8);
      label85:
      if (paramView4 != null) {
        break label555;
      }
      this.Jd.findViewById(2131374948).setVisibility(8);
    }
    for (;;)
    {
      if (localViewGroup.getChildAt(0) != null) {
        b(paramJSONObject, "qq", localViewGroup.getChildAt(0).findViewById(2131368698));
      }
      if (localViewGroup.getChildAt(1) != null) {
        b(paramJSONObject, "p", localViewGroup.getChildAt(1).findViewById(2131368698));
      }
      if (paramView1 != null)
      {
        paramView1.setPadding(dip2px(10.0F), dip2px(12.0F), dip2px(10.0F), dip2px(12.0F));
        a(paramJSONObject, paramView1);
      }
      if (this.c.cwc)
      {
        paramJSONObject = (ViewGroup)this.Jd.findViewById(2131361886);
        paramView2 = this.Jd.findViewById(2131361887);
        if (paramView2 != null) {
          paramView2.setVisibility(8);
        }
        if (paramView3 != null) {
          paramView3.setVisibility(8);
        }
        if (paramView4 != null) {
          paramView4.setVisibility(8);
        }
        if ((paramView5 != null) && (paramView5.getParent() == null))
        {
          ((TextView)paramView5.findViewById(2131369466)).setTextColor(this.mColor);
          ((ImageView)paramView5.findViewById(2131368698)).clearColorFilter();
          ((ImageView)paramView5.findViewById(2131368698)).setColorFilter(this.mColor);
          paramJSONObject.addView(paramView5, 0);
        }
        if ((paramView6 != null) && (paramView6.getParent() == null))
        {
          ((TextView)paramView6.findViewById(2131369466)).setTextColor(this.mColor);
          ((ImageView)paramView6.findViewById(2131368698)).clearColorFilter();
          ((ImageView)paramView6.findViewById(2131368698)).setColorFilter(this.mColor);
          paramJSONObject.addView(paramView6, 0);
        }
        if ((paramView7 != null) && (paramView7.getParent() == null))
        {
          ((TextView)paramView7.findViewById(2131369466)).setTextColor(this.mColor);
          ((ImageView)paramView7.findViewById(2131368698)).clearColorFilter();
          ((ImageView)paramView7.findViewById(2131368698)).setColorFilter(this.mColor);
          paramJSONObject.addView(paramView7, paramJSONObject.getChildCount());
        }
      }
      return paramView1;
      localObject = (TextView)localViewGroup.findViewById(2131361888);
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setTextColor(this.mColor);
      break;
      label518:
      b(paramJSONObject, "sign", paramView2.findViewById(2131368698));
      break label66;
      label536:
      b(paramJSONObject, "lv", paramView3.findViewById(2131368698));
      break label85;
      label555:
      b(paramJSONObject, "metal", paramView4.findViewById(2131368698));
    }
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
    throws IllegalArgumentException
  {
    paramString = pV(paramString);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  protected URLDrawable a(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.cyk; TextUtils.isEmpty(paramJSONObject); paramJSONObject = paramJSONObject.optString("cbg", this.cyk)) {
      return null;
    }
    return a(paramJSONObject, new aqvx.b(paramInt1, paramInt2));
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131562205);
  }
  
  public void a(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, alcn paramalcn)
  {
    ProfileCardFavorShowView localProfileCardFavorShowView = a(this.mActivity);
    paramQQAppInterface = new PersonalityLabelBoard(this.mActivity, paramQQAppInterface, paramalcn.e.uin, localProfileCardFavorShowView);
    if ((this.mActivity instanceof FriendProfileCardActivity)) {
      paramQQAppInterface.setScrollListener((PersonalityLabelBoard.a)this.mActivity);
    }
    localProfileCardFavorShowView.setTitle(acfp.m(2131709965));
    localProfileCardFavorShowView.setVisibility(8);
    localProfileCardFavorShowView.addView(paramQQAppInterface);
    paramHashMap.put("map_key_personality_label_board", localProfileCardFavorShowView);
  }
  
  public void a(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, alcn paramalcn, PhotoWallView.b paramb)
  {
    paramQQAppInterface = new TemplatePhotoWall(this.mActivity, paramQQAppInterface, paramalcn.e.uin, paramb);
    paramalcn = (ProfileCardDiyPhotoWallView)paramQQAppInterface.findViewById(2131373205).findViewById(2131373205);
    paramalcn.setMargin(rpq.dip2px(this.mActivity, 8.0F));
    paramalcn.setBorderWidth(this.mBorderWidth);
    paramalcn = a(this.mActivity);
    paramalcn.setTitle(acfp.m(2131709966));
    paramalcn.setVisibility(8);
    paramalcn.addView(paramQQAppInterface);
    paramHashMap.put("map_key_photo_wall", paramalcn);
  }
  
  public void a(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, alcn paramalcn, boolean paramBoolean)
  {
    paramQQAppInterface = a(this.mActivity);
    paramQQAppInterface.setTitle(this.mActivity.getString(2131692166));
    paramQQAppInterface.setVisibility(8);
    paramQQAppInterface.setOnClickListener(null);
    if (paramBoolean) {
      paramQQAppInterface.setShowArrow(false);
    }
    paramHashMap.put("map_key_extend_friend_info", paramQQAppInterface);
  }
  
  public void a(HashMap<String, View> paramHashMap, Card paramCard)
  {
    aleo localaleo = new aleo(true);
    paramCard = localaleo.b(this.mActivity, paramCard.uin);
    localaleo.d(this.c);
    paramCard.setTag(2131562224, localaleo);
    paramHashMap.put("map_key_music_box", paramCard);
  }
  
  protected void a(JSONObject paramJSONObject, View paramView)
  {
    if (paramView == null) {
      return;
    }
    cZ(paramView);
    a(paramJSONObject, paramView, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, int paramInt1, int paramInt2)
  {
    String str;
    if (paramJSONObject == null)
    {
      str = this.cyg;
      if (paramJSONObject != null) {
        break label74;
      }
    }
    label74:
    for (paramJSONObject = "null module";; paramJSONObject = paramJSONObject.optString("type"))
    {
      if (!TextUtils.isEmpty(str)) {
        break label85;
      }
      ram.w("DIYProfileTemplate.ProfileTemplateBase", "setModuleBackground " + paramJSONObject + " ,but it is null.");
      return;
      str = paramJSONObject.optString("bg", this.cyg);
      break;
    }
    label85:
    if (paramView == null)
    {
      rom.fail("setModuleBackground cant find " + paramJSONObject + " view", new Object[0]);
      return;
    }
    try
    {
      URLDrawable localURLDrawable = a(str, new aqvx.b(paramInt1, paramInt2));
      paramView.setBackgroundDrawable(localURLDrawable);
      localURLDrawable.setURLDrawableListener(new aqvx.a(paramView));
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      rom.fail("setModuleBackground " + paramJSONObject + " url illegal:" + str + " \ne:" + paramView, new Object[0]);
    }
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, TextView paramTextView, ImageView paramImageView)
  {
    if (paramView != null)
    {
      String str = s(paramJSONObject);
      if (!TextUtils.isEmpty(str)) {
        paramView.setBackgroundDrawable(e(str));
      }
    }
    else if (paramImageView != null)
    {
      paramView = t(paramJSONObject);
      if (TextUtils.isEmpty(paramView)) {
        break label115;
      }
      paramImageView.setImageDrawable(e(paramView));
    }
    for (;;)
    {
      if (paramTextView != null) {
        paramTextView.setTextColor(this.mColor);
      }
      return;
      if (paramJSONObject != null) {
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind title icon is null!");
      }
      paramView.setVisibility(8);
      break;
      label115:
      if (paramJSONObject != null) {
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind arrow icon is null!");
      }
      paramImageView.setVisibility(8);
    }
  }
  
  public void a(JSONObject paramJSONObject, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (paramProfileCardFavorShowView == null) {
      return;
    }
    if (paramProfileCardFavorShowView.MI() > 0)
    {
      View localView = paramProfileCardFavorShowView.S(0);
      cZ(localView);
      a(paramJSONObject, paramProfileCardFavorShowView.getContainer(), localView.getMeasuredWidth(), localView.getMeasuredHeight());
    }
    for (;;)
    {
      a(paramJSONObject, paramProfileCardFavorShowView.findViewById(2131368698), (TextView)paramProfileCardFavorShowView.findViewById(2131379562), (ImageView)paramProfileCardFavorShowView.findViewById(2131368865));
      return;
      a(paramJSONObject, paramProfileCardFavorShowView.getContainer());
    }
  }
  
  public View b(JSONObject paramJSONObject, View paramView)
  {
    View localView = paramView.findViewById(2131369181);
    Object localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = dip2px(15.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = dip2px(15.0F);
    ((LinearLayout.LayoutParams)localObject1).height = dip2px(74.0F);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramView.findViewById(2131368698);
    Object localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).width = dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject2).height = dip2px(28.0F);
    ((LinearLayout.LayoutParams)localObject2).topMargin = 0;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (TextView)paramView.findViewById(2131379562);
    ((TextView)localObject2).setTextSize(1, 20.0F);
    ((TextView)localObject2).setTypeface(((TextView)localObject2).getTypeface(), 1);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368865);
    localImageView.getLayoutParams().width = dip2px(18.0F);
    localImageView.getLayoutParams().height = dip2px(18.0F);
    localImageView.setLayoutParams(localImageView.getLayoutParams());
    Object localObject3 = (TextView)paramView.findViewById(2131378564);
    ((TextView)localObject3).setTextColor(this.mColor);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject3).getLayoutParams();
    localLayoutParams.topMargin = dip2px(22.0F);
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    localObject3 = paramView.findViewById(2131378723);
    localLayoutParams = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
    localLayoutParams.topMargin = dip2px(19.0F);
    localLayoutParams.leftMargin = dip2px(19.0F);
    ((View)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)paramView.findViewById(2131366432)).setTextColor(this.mColor);
    localObject3 = (TextView)paramView.findViewById(2131378563);
    ((TextView)localObject3).setTextColor(this.mColor);
    ((TextView)localObject3).setAlpha(0.2509804F);
    a(paramJSONObject, (View)localObject1, (TextView)localObject2, localImageView);
    a(paramJSONObject, localView);
    if (paramView.getTag(2131562224) != null) {
      ((aleo)paramView.getTag(2131562224)).d(this.c);
    }
    return paramView;
  }
  
  public List<View> b(HashMap<String, View> paramHashMap, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.cc.optJSONArray("module");
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      rom.fail("DIYProfileTemplate.ProfileTemplateBasethere is no module!", new Object[0]);
      return localArrayList;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    JSONObject localJSONObject1;
    if (i < ((JSONArray)localObject).length())
    {
      localJSONObject1 = ((JSONArray)localObject).optJSONObject(i);
      if (localJSONObject1 == null) {
        ram.e("DIYProfileTemplate.ProfileTemplateBase", "module array[" + i + "] is null");
      }
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(localJSONObject1.optString("type"), localJSONObject1);
      }
    }
    int j = 0;
    i = 0;
    if (i < paramArrayOfString.length)
    {
      localJSONObject1 = null;
      if ((paramArrayOfString[i].equals("map_key_account_base_info")) || (paramArrayOfString[i].equals("map_key_sig")) || (paramArrayOfString[i].equals("map_key_account_level_info")) || (paramArrayOfString[i].equals("map_key_medal_and_diamond")) || (paramArrayOfString[i].equals("map_key_troop_mem_add_time")) || (paramArrayOfString[i].equals("map_key_troop_mem_charm_level")) || (paramArrayOfString[i].equals("map_key_troop_mem_recent_said")))
      {
        if (j != 0) {
          break label704;
        }
        localObject = a(a(localHashMap, "info"), (View)paramHashMap.get("map_key_account_base_info"), (View)paramHashMap.get("map_key_sig"), (View)paramHashMap.get("map_key_account_level_info"), (View)paramHashMap.get("map_key_medal_and_diamond"), (View)paramHashMap.get("map_key_troop_mem_add_time"), (View)paramHashMap.get("map_key_troop_mem_charm_level"), (View)paramHashMap.get("map_key_troop_mem_recent_said"));
        j = 1;
      }
    }
    for (;;)
    {
      label322:
      if (localObject != null) {
        if (((View)localObject).getParent() != null) {
          break label695;
        }
      }
      label695:
      for (boolean bool = true;; bool = false)
      {
        rom.assertTrue(bool, "makeModuleList error :" + paramArrayOfString[i] + " have a parent!");
        localArrayList.add(localObject);
        i += 1;
        break;
        if (paramArrayOfString[i].equals("map_key_qzone"))
        {
          localObject = a(a(localHashMap, "qz"), (View)paramHashMap.get("map_key_qzone"));
          break label322;
        }
        if (paramArrayOfString[i].equals("map_key_photo_wall"))
        {
          localObject = c(a(localHashMap, "photo"), (View)paramHashMap.get("map_key_photo_wall"));
          break label322;
        }
        if (paramArrayOfString[i].equals("map_key_personality_label_board"))
        {
          localObject = d(a(localHashMap, "tag"), (View)paramHashMap.get("map_key_personality_label_board"));
          break label322;
        }
        if (paramArrayOfString[i].equals("map_key_extend_friend_info"))
        {
          localObject = e(a(localHashMap, "exp"), (View)paramHashMap.get("map_key_extend_friend_info"));
          break label322;
        }
        if (paramArrayOfString[i].equals("map_key_favor"))
        {
          localObject = f(a(localHashMap, "recent"), (View)paramHashMap.get("map_key_favor"));
          break label322;
        }
        if (paramArrayOfString[i].equals("map_key_present"))
        {
          localObject = null;
          break label322;
        }
        if (paramArrayOfString[i].equals("map_key_music_box"))
        {
          JSONObject localJSONObject2 = a(localHashMap, "qz");
          localObject = localJSONObject1;
          if (aleo.c(this.c))
          {
            localObject = localJSONObject1;
            if (paramHashMap.containsKey("map_key_music_box")) {
              localObject = b(localJSONObject2, (View)paramHashMap.get("map_key_music_box"));
            }
          }
          break label322;
        }
        localObject = k((View)paramHashMap.get(paramArrayOfString[i]));
        break label322;
      }
      return localArrayList;
      label704:
      localObject = null;
    }
  }
  
  public void b(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    if (("map_key_phone".equals(paramString)) || ("map_key_sig".equals(paramString)) || ("map_key_mine_weishi".equals(paramString)) || ("map_key_favor".equals(paramString)) || ("map_key_account_base_info".equals(paramString)))
    {
      if (paramTextView != null) {
        paramTextView.setTextColor(this.mColor);
      }
      if (!(paramView instanceof TextView)) {
        break label79;
      }
      ((TextView)paramView).setTextColor(this.mColor);
    }
    label79:
    do
    {
      return;
      if ((paramView instanceof SingleLineTextView))
      {
        ((SingleLineTextView)paramView).setTextColor(this.mColor);
        return;
      }
    } while (!(paramView instanceof ImageView));
    ((ImageView)paramView).setColorFilter(this.mColor);
  }
  
  public void b(JSONObject paramJSONObject, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (paramProfileCardFavorShowView == null) {
      return;
    }
    a(paramJSONObject, paramProfileCardFavorShowView.getContainer());
    a(paramJSONObject, paramProfileCardFavorShowView.findViewById(2131368698), (TextView)paramProfileCardFavorShowView.findViewById(2131379562), (ImageView)paramProfileCardFavorShowView.findViewById(2131368865));
  }
  
  protected void b(JSONObject paramJSONObject, String paramString, View paramView)
  {
    paramJSONObject = paramJSONObject.optString(paramString);
    if (TextUtils.isEmpty(paramJSONObject))
    {
      ram.w("DIYProfileTemplate.ProfileTemplateBase", "setBaseInfoIcon " + paramString + " icon,but it is null.");
      return;
    }
    if (paramView == null)
    {
      ram.e("DIYProfileTemplate.ProfileTemplateBase", "setBaseInfoIcon cant find " + paramString + " view");
      return;
    }
    try
    {
      URLDrawable localURLDrawable = e(paramJSONObject);
      paramView.setBackgroundDrawable(localURLDrawable);
      localURLDrawable.setURLDrawableListener(new aqvx.a(paramView));
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      rom.fail("setBaseInfoIcon " + paramString + " url illegal:" + paramJSONObject + " \ne:" + paramView, new Object[0]);
    }
  }
  
  public View c(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof ProfileCardFavorShowView)) {}
    Object localObject;
    PhotoWallView localPhotoWallView;
    do
    {
      return paramView;
      localObject = (ProfileCardFavorShowView)paramView;
      localPhotoWallView = (PhotoWallView)((ProfileCardFavorShowView)localObject).S(0);
      ProfileCardDiyPhotoWallView localProfileCardDiyPhotoWallView = (ProfileCardDiyPhotoWallView)localPhotoWallView.findViewById(2131373205).findViewById(2131373205);
      localProfileCardDiyPhotoWallView.setItemViewBorderColor(g(paramJSONObject));
      localProfileCardDiyPhotoWallView.setBorderImgUrl(r(paramJSONObject));
      localProfileCardDiyPhotoWallView.setBorderWidth(h(paramJSONObject));
      a(paramJSONObject, ((ProfileCardFavorShowView)localObject).findViewById(2131368698), (TextView)((ProfileCardFavorShowView)localObject).findViewById(2131379562), (ImageView)((ProfileCardFavorShowView)localObject).findViewById(2131368865));
      localObject = localPhotoWallView.findViewById(2131373197);
    } while (((View)localObject).getVisibility() != 0);
    ((View)localObject).setPadding(dip2px(10.0F), dip2px(15.0F), dip2px(10.0F), dip2px(10.0F));
    cZ(localPhotoWallView);
    a(paramJSONObject, (View)localObject, localPhotoWallView.getMeasuredWidth(), localPhotoWallView.getMeasuredHeight());
    return paramView;
  }
  
  public View d(JSONObject paramJSONObject, View paramView)
  {
    if (paramView == null) {
      return null;
    }
    ProfileCardFavorShowView localProfileCardFavorShowView = (ProfileCardFavorShowView)paramView;
    localProfileCardFavorShowView.getContainer().setPadding(dip2px(24.0F), dip2px(21.0F), dip2px(24.0F), dip2px(21.0F));
    try
    {
      ((PersonalityLabelBoard)localProfileCardFavorShowView.S(0)).a.setTextColor(this.mColor);
      if (localProfileCardFavorShowView.MI() > 0)
      {
        View localView = localProfileCardFavorShowView.S(0);
        localView.measure(View.MeasureSpec.makeMeasureSpec(rpq.getScreenWidth(this.mActivity) - rpq.dip2px(this.mActivity, 78.0F), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        a(paramJSONObject, localProfileCardFavorShowView.getContainer(), localView.getMeasuredWidth(), localView.getMeasuredHeight());
        a(paramJSONObject, localProfileCardFavorShowView.findViewById(2131368698), (TextView)localProfileCardFavorShowView.findViewById(2131379562), (ImageView)localProfileCardFavorShowView.findViewById(2131368865));
        return paramView;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ram.e("DIYProfileTemplate.ProfileTemplateBase", "getTagView error personalityLabelBoard is null");
        continue;
        a(paramJSONObject, localProfileCardFavorShowView.getContainer());
      }
    }
  }
  
  public int dip2px(float paramFloat)
  {
    return (int)(this.mActivity.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public View e(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof ProfileCardFavorShowView)) {}
    do
    {
      return paramView;
      ProfileCardFavorShowView localProfileCardFavorShowView = (ProfileCardFavorShowView)paramView;
      localProfileCardFavorShowView.getContainer().setPadding(dip2px(10.0F), dip2px(10.0F), dip2px(10.0F), dip2px(10.0F));
      a(paramJSONObject, localProfileCardFavorShowView);
      paramJSONObject = localProfileCardFavorShowView.S(0);
      if (paramJSONObject == null) {
        return null;
      }
    } while (!(paramJSONObject instanceof ProfileCardExtendFriendView));
    paramJSONObject = (ProfileCardExtendFriendView)paramJSONObject;
    return paramView;
  }
  
  protected URLDrawable e(String paramString)
    throws IllegalArgumentException
  {
    return a(paramString, null);
  }
  
  public View f(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof LinearLayout)) {
      return paramView;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    int i = 0;
    label17:
    Object localObject;
    if (i < localLinearLayout.getChildCount())
    {
      localObject = localLinearLayout.getChildAt(i);
      if ((localObject instanceof ProfileCardFavorShowView)) {
        break label49;
      }
    }
    for (;;)
    {
      i += 1;
      break label17;
      break;
      label49:
      localObject = (ProfileCardFavorShowView)localObject;
      ((ProfileCardFavorShowView)localObject).getContainer().setPadding(dip2px(10.0F), dip2px(10.0F), dip2px(10.0F), dip2px(10.0F));
      b(paramJSONObject, (ProfileCardFavorShowView)localObject);
    }
  }
  
  protected int g(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("line");
    int i = this.gW;
    if (TextUtils.isEmpty(str)) {
      return i;
    }
    try
    {
      int j = Color.parseColor(str);
      return j;
    }
    catch (Exception localException)
    {
      rom.fail("DIYProfileTemplate.ProfileTemplateBase story line color is illegal module=" + paramJSONObject.optString("type") + " value=" + paramJSONObject.optString("line"), new Object[0]);
    }
    return i;
  }
  
  protected int h(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (int i = this.edj; i == 0; i = paramJSONObject.optInt("cpd", this.edj)) {
      return this.mBorderWidth;
    }
    return dip2px(i / 2);
  }
  
  public View k(View paramView)
  {
    if ((paramView instanceof ProfileCardFavorShowView))
    {
      localObject = (ProfileCardFavorShowView)paramView;
      ((ProfileCardFavorShowView)localObject).getContainer().setPadding(dip2px(10.0F), dip2px(10.0F), dip2px(10.0F), dip2px(10.0F));
      b(null, (ProfileCardFavorShowView)localObject);
    }
    while (paramView == null) {
      return paramView;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new LinearLayout.LayoutParams(-1, -2);
    }
    ((LinearLayout.LayoutParams)localObject).leftMargin = rpq.dip2px(this.mActivity, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = rpq.dip2px(this.mActivity, 15.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = rpq.dip2px(this.mActivity, 20.0F);
    ((LinearLayout.LayoutParams)localObject).bottomMargin = rpq.dip2px(this.mActivity, 20.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setPadding(dip2px(10.0F), dip2px(10.0F), dip2px(10.0F), dip2px(10.0F));
    a(null, paramView);
    return paramView;
  }
  
  protected String pV(@NonNull String paramString)
  {
    if (paramString.startsWith("http")) {}
    while (TextUtils.isEmpty(this.bWn)) {
      return paramString;
    }
    if (this.bWn.startsWith("http")) {
      return this.bWn + paramString;
    }
    QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, "it have the illegal url prefix=" + this.bWn);
    return paramString;
  }
  
  protected String r(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return this.cyk;
    }
    return paramJSONObject.optString("cbg", this.cyk);
  }
  
  protected String s(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.cyh;; paramJSONObject = paramJSONObject.optString("t_bg"))
    {
      Object localObject = paramJSONObject;
      if (TextUtils.isEmpty(paramJSONObject)) {
        localObject = this.cyh;
      }
      return localObject;
    }
  }
  
  protected String t(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.cyi;; paramJSONObject = paramJSONObject.optString("arr"))
    {
      Object localObject = paramJSONObject;
      if (TextUtils.isEmpty(paramJSONObject)) {
        localObject = this.cyi;
      }
      return localObject;
    }
  }
  
  public static class a
    extends aoop.a
  {
    private WeakReference<View> X;
    
    public a(View paramView)
    {
      this.X = new WeakReference(paramView);
    }
    
    public static void a(URLDrawable paramURLDrawable, View paramView)
    {
      if (paramURLDrawable.getStatus() != 1) {
        paramURLDrawable.setURLDrawableListener(new a(paramView));
      }
    }
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      paramURLDrawable = (View)this.X.get();
      if (paramURLDrawable != null) {
        paramURLDrawable.invalidate();
      }
    }
  }
  
  public static class b
    implements DownloadParams.DecodeHandler
  {
    private int edk;
    private int edl;
    
    @Deprecated
    public b() {}
    
    public b(int paramInt1, int paramInt2)
    {
      this.edk = paramInt1;
      this.edl = paramInt2;
    }
    
    public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
    {
      return aqlt.u(paramBitmap, this.edk, this.edl);
    }
    
    @Deprecated
    public void setSize(int paramInt1, int paramInt2)
    {
      this.edk = paramInt1;
      this.edl = paramInt2;
    }
    
    public String toString()
    {
      return "NinePatchDecoderHandler{reqW=" + this.edk + ", reqH=" + this.edl + '}';
    }
  }
  
  public static class c
    implements DownloadParams.DecodeHandler
  {
    private int AD;
    private boolean cWF;
    private Paint mPaint;
    
    public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
    {
      if (paramBitmap == null) {
        paramDownloadParams = null;
      }
      Bitmap localBitmap;
      Path localPath;
      Canvas localCanvas;
      do
      {
        return paramDownloadParams;
        paramBitmap.setDensity((int)aqnm.getDensityDpi());
        localBitmap = aqfi.createBitmap(paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, Bitmap.Config.ARGB_8888);
        this.mPaint.setStrokeWidth(this.AD * 2);
        localPath = new Path();
        localCanvas = new Canvas(localBitmap);
        localCanvas.save();
        localPath.moveTo(this.AD, this.AD);
        localPath.lineTo(localBitmap.getWidth() - this.AD, this.AD);
        localPath.lineTo(localBitmap.getWidth() - this.AD, localBitmap.getHeight() - this.AD);
        localPath.lineTo(this.AD, localBitmap.getHeight() - this.AD);
        localPath.close();
        localPath.setFillType(Path.FillType.EVEN_ODD);
        localCanvas.clipPath(localPath);
        localCanvas.drawBitmap(paramBitmap, new Rect(0, (paramBitmap.getHeight() - paramBitmap.getWidth()) / 2, paramBitmap.getWidth(), (paramBitmap.getWidth() + paramBitmap.getHeight()) / 2), new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), this.mPaint);
        localCanvas.restore();
        paramDownloadParams = localBitmap;
      } while (this.cWF);
      localCanvas.drawPath(localPath, this.mPaint);
      return localBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvx
 * JD-Core Version:    0.7.0.1
 */