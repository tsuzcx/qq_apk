import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lafmi;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class afgf
  extends BaseAdapter
  implements Handler.Callback, View.OnClickListener, AdapterView.c, GestureSelectGridView.b
{
  TextView Ru;
  public TextView Rv;
  private affr jdField_a_of_type_Affr;
  private volatile afgf.b jdField_a_of_type_Afgf$b;
  private boolean aTU;
  private boolean aTV;
  private QQAppInterface app;
  private boolean bXT;
  private volatile int cQK = 0;
  IphoneTitleBarActivity d;
  Button fX;
  Button fY;
  RelativeLayout jR;
  RelativeLayout jS;
  RelativeLayout jT;
  TextView leftView;
  float mDensity;
  GestureSelectGridView mGridView;
  private Handler mHandler;
  int mImgHeight;
  int mImgWidth;
  LayoutInflater mInflater;
  private int mMaxIndex = -2147483648;
  private int mMinIndex = 2147483647;
  private volatile boolean oA;
  TextView rightViewText;
  public TextView sx;
  private int thumbWidth;
  List<afmi> zA = null;
  List<afmi> zB = null;
  
  public afgf(QQAppInterface paramQQAppInterface, IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    this.app = paramQQAppInterface;
    this.d = paramIphoneTitleBarActivity;
    this.mInflater = paramIphoneTitleBarActivity.getLayoutInflater();
    this.mDensity = paramIphoneTitleBarActivity.getApplicationContext().getResources().getDisplayMetrics().density;
    this.mHandler = new auru(Looper.getMainLooper(), this);
    this.thumbWidth = wja.dp2px(88.0F, paramIphoneTitleBarActivity.getResources());
  }
  
  private void Mp(int paramInt)
  {
    if (this.cQK == 0) {
      this.d.setTitle(this.jdField_a_of_type_Affr.CQ());
    }
    while (this.cQK != 1) {
      return;
    }
    String str = String.format(this.d.getString(2131693068), new Object[] { Integer.valueOf(paramInt) });
    this.d.setTitle(str);
  }
  
  private void Mq(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.zB != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.zB.size())
      {
        localObject1 = (afmi)this.zB.get(paramInt);
        this.zB.remove(paramInt);
      }
    }
    if ((this.zA != null) && (localObject1 != null))
    {
      this.zA.remove(localObject1);
      afhv.a(this.app).j(Integer.valueOf(((afmi)localObject1).emoId));
    }
  }
  
  private void a(afgf.a parama)
  {
    parama.BH.setVisibility(8);
    parama.BI.setVisibility(0);
    parama.BJ.setVisibility(8);
    parama.aZ.setVisibility(0);
    Animatable localAnimatable = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839651);
    parama.yG.setImageDrawable((Drawable)localAnimatable);
    localAnimatable.start();
    parama.yG.setVisibility(0);
    if (this.cQK == 1)
    {
      parama.yF.setVisibility(0);
      return;
    }
    parama.yF.setVisibility(8);
  }
  
  private void a(afmi paramafmi, String paramString, afgf.a parama)
  {
    if ((TextUtils.isEmpty(paramString)) || (parama == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "updateViewStatus holder is null");
      }
    }
    do
    {
      return;
      parama.aZ.setURLDrawableDownListener(null);
      if (paramString.equals("needUpload"))
      {
        a(parama);
        return;
      }
      if (paramString.equals("failed"))
      {
        b(parama);
        return;
      }
      c(parama);
    } while (!(paramafmi.a(this.d.getBaseContext(), 0.0F, this.thumbWidth, this.thumbWidth) instanceof URLDrawable));
    parama.aZ.setURLDrawableDownListener(new afgm(this, paramafmi, parama));
    a(parama.aZ, parama);
  }
  
  private void a(URLImageView paramURLImageView, afgf.a parama)
  {
    if ((paramURLImageView.getDrawable() instanceof URLDrawable))
    {
      paramURLImageView = (URLDrawable)paramURLImageView.getDrawable();
      if (paramURLImageView.getStatus() == 0) {
        a(parama);
      }
    }
    else
    {
      return;
    }
    if ((paramURLImageView.getStatus() == 2) || (paramURLImageView.getStatus() == 3))
    {
      b(parama);
      return;
    }
    c(parama);
  }
  
  private List<afmi> aZ(List<afmi> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = t();
    if ((paramList != null) && (paramList.size() > 0) && (localConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        afmi localafmi = (afmi)localIterator.next();
        if (localConcurrentHashMap.containsKey(Integer.valueOf(localafmi.emoId))) {
          localafmi.isChecked = true;
        }
      }
    }
    return paramList;
  }
  
  private void ah(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_PANEL");
    }
    paramView = (afgf.a)paramView.getTag();
    Object localObject = paramView.aZ.getDrawable();
    if ((localObject instanceof URLDrawable))
    {
      localObject = (URLDrawable)localObject;
      if ((((URLDrawable)localObject).getStatus() != 3) && (((URLDrawable)localObject).getStatus() != 2)) {
        break label101;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "onItemClick restartDownload status = " + ((URLDrawable)localObject).getStatus());
      }
      ((URLDrawable)localObject).restartDownload();
    }
    label101:
    while (((URLDrawable)localObject).getStatus() != 1) {
      return;
    }
    AIOEmotionFragment.a(this.d, (afmi)getItem(paramInt), sxx.getViewRect(paramView.aZ));
  }
  
  private void b(afgf.a parama)
  {
    parama.BH.setVisibility(8);
    parama.BI.setVisibility(0);
    parama.BJ.setVisibility(0);
    parama.yG.setVisibility(8);
    parama.aZ.setVisibility(0);
    if (this.cQK == 1)
    {
      parama.yF.setVisibility(0);
      return;
    }
    parama.yF.setVisibility(8);
  }
  
  private boolean b(afmi paramafmi)
  {
    if ((paramafmi instanceof afpg))
    {
      paramafmi = (afpg)paramafmi;
      if ((TextUtils.isEmpty(paramafmi.bDZ)) || (!paramafmi.bDZ.equals("failed"))) {}
    }
    do
    {
      return true;
      return false;
      if (!(paramafmi instanceof afpu)) {
        break;
      }
      paramafmi = (afpu)paramafmi;
    } while ((!TextUtils.isEmpty(paramafmi.bDZ)) && (paramafmi.bDZ.equals("failed")));
    return false;
    return false;
  }
  
  private void c(afgf.a parama)
  {
    parama.BH.setVisibility(8);
    parama.BI.setVisibility(8);
    parama.BJ.setVisibility(8);
    parama.yG.setVisibility(8);
    parama.aZ.setVisibility(0);
    if (this.cQK == 1)
    {
      parama.yF.setVisibility(0);
      return;
    }
    parama.yF.setVisibility(8);
  }
  
  private void cZa()
  {
    if (this.cQK == 1)
    {
      this.cQK = 0;
      this.jdField_a_of_type_Affr.cQ.set(true);
      this.jR.setVisibility(8);
      this.jT.setVisibility(8);
      this.rightViewText.setText(2131693069);
      this.rightViewText.setContentDescription(this.d.getString(2131693070));
      localIterator = this.zB.iterator();
      while (localIterator.hasNext()) {
        ((afmi)localIterator.next()).isChecked = false;
      }
      this.jdField_a_of_type_Affr.cYR();
      cZe();
      if (this.oA)
      {
        cZi();
        bYN();
      }
      if (this.jdField_a_of_type_Afgf$b != null) {
        this.jdField_a_of_type_Afgf$b.db(false);
      }
      anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
    }
    while (this.cQK != 0)
    {
      Iterator localIterator;
      return;
    }
    this.cQK = 1;
    this.mGridView.setSelectMode(true);
    this.jdField_a_of_type_Affr.cQ.set(false);
    this.jR.setVisibility(0);
    Mp(0);
    this.rightViewText.setText(2131721066);
    this.rightViewText.setContentDescription(this.d.getString(2131693050));
    if ((this.jdField_a_of_type_Affr.ajg()) || (VipUtils.ce((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      this.jS.setVisibility(8);
    }
    this.Ru.setAlpha(0.3F);
    this.sx.setAlpha(0.3F);
    this.Rv.setAlpha(0.3F);
    this.jdField_a_of_type_Affr.cYQ();
    this.jdField_a_of_type_Affr.cYT();
    if (this.jdField_a_of_type_Afgf$b != null) {
      this.jdField_a_of_type_Afgf$b.db(true);
    }
    anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
  }
  
  private void cZb()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.d.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.d.requestPermissions(new afgg(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        cZd();
        this.jdField_a_of_type_Affr.cYU();
        return;
        i = 1;
      }
    }
  }
  
  private void cZc()
  {
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    Object localObject3;
    if (this.zB != null)
    {
      this.oA = true;
      localArrayList4 = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localObject2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localObject3 = new ArrayList();
      localObject1 = ((afhu)this.app.getManager(149)).ez();
      localObject4 = this.zB.iterator();
      for (;;)
      {
        label95:
        if (!((Iterator)localObject4).hasNext()) {
          break label292;
        }
        afmi localafmi = (afmi)((Iterator)localObject4).next();
        if (localafmi.isChecked)
        {
          localafmi.isChecked = false;
          if (b(localafmi)) {
            localArrayList2.add(localafmi);
          }
          for (i = 1;; i = 0)
          {
            if (localObject1 == null) {
              break label255;
            }
            Iterator localIterator = ((List)localObject1).iterator();
            if (!localIterator.hasNext()) {
              break label95;
            }
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
            if (localCustomEmotionData.emoId != localafmi.emoId) {
              break;
            }
            if ((i == 0) && (!TextUtils.isEmpty(localCustomEmotionData.resid))) {
              localArrayList4.add(localCustomEmotionData.resid);
            }
            localArrayList1.add(localCustomEmotionData);
            break label95;
            localArrayList3.add(localafmi);
          }
        }
        else
        {
          label255:
          if (b(localafmi)) {
            ((List)localObject2).add(localafmi);
          } else {
            ((List)localObject3).add(localafmi);
          }
        }
      }
      label292:
      if ((localArrayList3.size() != 0) || (localArrayList2.size() != 0)) {
        break label329;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "handleEmotionMove selectedList is empty!");
      }
    }
    return;
    label329:
    Object localObject4 = (acef)this.app.getBusinessHandler(72);
    if (localObject4 != null) {
      ((acef)localObject4).iI(localArrayList4);
    }
    ArrayList localArrayList4 = new ArrayList();
    if (localArrayList2.size() > 0) {
      localArrayList4.addAll(localArrayList2);
    }
    if (((List)localObject2).size() > 0) {
      localArrayList4.addAll((Collection)localObject2);
    }
    if (localArrayList3.size() > 0) {
      localArrayList4.addAll(localArrayList3);
    }
    if (((List)localObject3).size() > 0) {
      localArrayList4.addAll((Collection)localObject3);
    }
    jX(localArrayList4);
    Object localObject2 = (afhu)this.app.getManager(149);
    int j = localArrayList1.size();
    Object localObject1 = ((List)localObject1).iterator();
    int i = 1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject3 = (CustomEmotionData)((Iterator)localObject1).next();
      if (i >= ((CustomEmotionData)localObject3).emoId) {
        break label654;
      }
      i = ((CustomEmotionData)localObject3).emoId;
    }
    label654:
    for (;;)
    {
      break;
      if (j > 0)
      {
        int k = j - 1;
        j = i;
        i = k;
        while (i >= 0)
        {
          localObject1 = (CustomEmotionData)localArrayList1.get(i);
          ((afhu)localObject2).a((CustomEmotionBase)localObject1);
          localObject1 = ((CustomEmotionData)localObject1).cloneEmotionData((CustomEmotionData)localObject1);
          j += 1;
          ((CustomEmotionData)localObject1).emoId = j;
          ((afhu)localObject2).c((CustomEmotionBase)localObject1);
          i -= 1;
        }
        ((afhu)localObject2).trimCache();
      }
      i = localArrayList3.size();
      j = localArrayList2.size();
      anot.a(this.app, "dc00898", "", "", "0X800A6D3", "0X800A6D3", 0, 0, String.valueOf(i + j), "", "", "");
      return;
    }
  }
  
  private void cZf()
  {
    Intent localIntent = new Intent(this.d, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 2);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("filter_photolist_troopalbum_toolbar", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE", true);
    localIntent.putExtra("peakconstant.request_code", 100015);
    this.d.startActivityForResult(localIntent, 100015);
  }
  
  private void cZg()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.d.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.d.requestPermissions(new afgl(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        cZf();
        anot.a(this.app, "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
        return;
        i = 1;
      }
    }
  }
  
  private void cZi()
  {
    if (this.oA)
    {
      this.oA = false;
      ((acef)this.app.getBusinessHandler(72)).notifyUI(2, true, null);
    }
  }
  
  private void coN()
  {
    ausj localausj = (ausj)auss.a(this.d, null);
    localausj.setMainTitle(2131693052);
    localausj.addButton(this.d.getString(2131693518), 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new afgh(this, localausj));
    localausj.show();
  }
  
  private void cpo()
  {
    if (this.zB == null) {
      return;
    }
    Iterator localIterator = this.zB.iterator();
    while (localIterator.hasNext()) {
      ((afmi)localIterator.next()).isChecked = false;
    }
    notifyDataSetChanged();
    cZe();
  }
  
  private ConcurrentHashMap<Integer, Boolean> t()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (this.zB != null)
    {
      Iterator localIterator = this.zB.iterator();
      while (localIterator.hasNext())
      {
        afmi localafmi = (afmi)localIterator.next();
        if (localafmi.isChecked) {
          localConcurrentHashMap.put(Integer.valueOf(localafmi.emoId), Boolean.valueOf(true));
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  public void a(affr paramaffr)
  {
    this.jdField_a_of_type_Affr = paramaffr;
    Resources localResources = this.d.getResources();
    int i = localResources.getDisplayMetrics().widthPixels;
    int j = wja.dp2px(0.0F, localResources);
    int k = wja.dp2px(4.0F, localResources);
    int m = wja.dp2px(4.0F, localResources);
    this.mImgWidth = ((i - j * 2 - k * 3) / 4);
    this.mImgHeight = this.mImgWidth;
    this.rightViewText = this.d.rightViewText;
    this.leftView = this.d.leftView;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131693069);
    this.rightViewText.setContentDescription(this.d.getString(2131693070));
    this.rightViewText.setOnClickListener(this);
    this.jR = ((RelativeLayout)this.d.findViewById(2131366311));
    this.fX = ((Button)this.d.findViewById(2131366313));
    this.Ru = ((TextView)this.d.findViewById(2131366312));
    this.sx = ((TextView)this.d.findViewById(2131366322));
    this.sx.setContentDescription(this.d.getString(2131693060));
    this.Rv = ((TextView)this.d.findViewById(2131371977));
    this.mGridView = ((GestureSelectGridView)this.d.findViewById(2131366320));
    this.mGridView.setSelectMode(false);
    this.jS = ((RelativeLayout)this.d.findViewById(2131366321));
    this.jS.setVisibility(8);
    this.jT = ((RelativeLayout)this.d.findViewById(2131366260));
    this.fX.setOnClickListener(this);
    this.Ru.setOnClickListener(this);
    this.sx.setOnClickListener(this);
    this.Rv.setOnClickListener(this);
    this.mGridView.setScrollBarStyle(0);
    this.mGridView.setNumColumns(4);
    this.mGridView.setColumnWidth(this.mImgWidth);
    this.mGridView.setHorizontalSpacing(k);
    this.mGridView.setVerticalSpacing(m);
    this.mGridView.setPadding(j, this.mGridView.getPaddingTop(), j, this.mGridView.getPaddingBottom());
    this.mGridView.setOnItemClickListener(this);
    this.mGridView.setOnIndexChangedListener(this);
    this.mGridView.setMaximumVelocity((int)(2500.0F * this.d.getResources().getDisplayMetrics().density));
    if ((paramaffr.s(this.d)) && (paramaffr.aWh))
    {
      this.rightViewText.setText(2131721059);
      if (this.leftView != null) {
        this.leftView.setVisibility(8);
      }
      this.fX.setVisibility(8);
    }
    this.fY = ((Button)this.d.findViewById(2131363852));
    this.fY.setOnClickListener(this);
    if ((paramaffr.ajg()) || (VipUtils.ce((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      this.jS.setVisibility(8);
    }
  }
  
  public void a(afgf.b paramb)
  {
    this.jdField_a_of_type_Afgf$b = paramb;
  }
  
  public void a(GridView paramGridView, int paramInt)
  {
    if ((paramGridView == null) || (paramInt < 0)) {}
    int i;
    int j;
    do
    {
      return;
      i = paramGridView.getFirstVisiblePosition();
      j = paramGridView.getLastVisiblePosition();
    } while ((paramInt < i) || (paramInt > j));
    getView(paramInt, paramGridView.getChildAt(paramInt - i), paramGridView);
  }
  
  public boolean aji()
  {
    return this.cQK == 1;
  }
  
  public void bYN()
  {
    this.jdField_a_of_type_Affr.a(new afgk(this));
  }
  
  void cZd()
  {
    if (this.zB == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.zB.iterator();
    while (((Iterator)localObject).hasNext())
    {
      afmi localafmi = (afmi)((Iterator)localObject).next();
      if (localafmi.isChecked) {
        localArrayList.add(localafmi);
      }
    }
    if (localArrayList.isEmpty())
    {
      ahao.OU(2131693682);
      return;
    }
    localObject = new ajlm(this.d);
    this.jdField_a_of_type_Affr.a().a(new afgi(this, (ajlm)localObject));
    this.jdField_a_of_type_Affr.a().jY(localArrayList);
  }
  
  void cZe()
  {
    if (this.zB == null) {
      return;
    }
    int i;
    if (getCount() > 0)
    {
      this.fX.setEnabled(true);
      this.fX.setTextColor(Color.parseColor("#00a5e0"));
      Iterator localIterator = this.zB.iterator();
      i = 0;
      label48:
      if (!localIterator.hasNext()) {
        break label103;
      }
      if (!((afmi)localIterator.next()).isChecked) {
        break label267;
      }
      i += 1;
    }
    label267:
    for (;;)
    {
      break label48;
      this.fX.setEnabled(false);
      this.fX.setTextColor(Color.parseColor("#cccccc"));
      break;
      label103:
      if (this.jdField_a_of_type_Affr.aWh)
      {
        if (i >= 0)
        {
          this.Ru.setEnabled(true);
          return;
        }
        this.Ru.setEnabled(false);
        return;
      }
      if (i > 0)
      {
        this.Ru.setEnabled(true);
        this.sx.setEnabled(true);
        this.Rv.setEnabled(true);
        this.Ru.setAlpha(1.0F);
        this.sx.setAlpha(1.0F);
        this.Rv.setAlpha(1.0F);
      }
      for (;;)
      {
        Mp(i);
        this.Ru.setText(this.d.getString(2131693051));
        return;
        this.Ru.setEnabled(false);
        this.sx.setEnabled(false);
        this.Rv.setEnabled(false);
        this.Ru.setAlpha(0.3F);
        this.sx.setAlpha(0.3F);
        this.Rv.setAlpha(0.3F);
      }
    }
  }
  
  void cZh()
  {
    if (this.jdField_a_of_type_Affr != null) {
      this.jdField_a_of_type_Affr.cYX();
    }
  }
  
  public void caS()
  {
    cZi();
    this.jdField_a_of_type_Afgf$b = null;
  }
  
  public void fw(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.zA != null))
    {
      Iterator localIterator = this.zA.iterator();
      while (localIterator.hasNext())
      {
        afmi localafmi = (afmi)localIterator.next();
        if (((localafmi instanceof afpg)) && (TextUtils.isEmpty(((afpg)localafmi).path)) && (((afpg)localafmi).path.equals(paramString1))) {
          ((afpg)localafmi).bDZ = paramString2;
        }
      }
    }
  }
  
  public int getCount()
  {
    if (this.zB != null) {
      return this.zB.size();
    }
    return 0;
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public Object getItem(int paramInt)
  {
    return this.zB.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    afgf.a locala;
    afmi localafmi;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(2131559283, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.mImgWidth, this.mImgHeight));
      locala = new afgf.a();
      locala.aZ = ((URLImageView)localView.findViewById(2131366317));
      locala.yF = ((ImageView)localView.findViewById(2131366319));
      locala.BH = localView.findViewById(2131366314);
      locala.BI = localView.findViewById(2131366315);
      locala.BJ = localView.findViewById(2131366316);
      locala.yG = ((ImageView)localView.findViewById(2131366318));
      localView.setTag(locala);
      localafmi = (afmi)this.zB.get(paramInt);
      if (localafmi != locala.aZ.getTag(2131381960))
      {
        if (localafmi.operateType != 1) {
          break label524;
        }
        locala.aZ.setImageResource(2130840173);
        if (AppSetting.enableTalkBack) {
          locala.aZ.setContentDescription(this.d.getString(2131693048));
        }
        label216:
        locala.aZ.setTag(2131381960, localafmi);
      }
      if ((localafmi instanceof afpn))
      {
        afpn localafpn = (afpn)localafmi;
        a(localafmi, localafpn.uy(), locala);
        if (localafpn.isChecked()) {
          break label559;
        }
        locala.BH.setVisibility(8);
        locala.yF.setImageResource(2130846607);
        label290:
        if (this.cQK != 1) {
          break label582;
        }
        locala.yF.setVisibility(0);
        label307:
        if (localafmi.operateType != 1)
        {
          paramView = this.jdField_a_of_type_Affr.a(localafmi);
          if ((!AppSetting.enableTalkBack) || (TextUtils.isEmpty(paramView)) || (locala.yF.getVisibility() != 0)) {
            break label648;
          }
          if (localafpn.isChecked()) {
            break label595;
          }
          if ((!AppSetting.enableTalkBack) || (TextUtils.isEmpty(paramView))) {
            break label648;
          }
          paramView = paramView + "," + this.app.getApp().getString(2131721546);
        }
      }
    }
    label648:
    for (;;)
    {
      locala.aZ.setContentDescription(paramView);
      if (localafmi.operateType == 1)
      {
        locala.BH.setVisibility(8);
        locala.yF.setVisibility(8);
        locala.BI.setVisibility(8);
        locala.BJ.setVisibility(8);
        locala.yG.setVisibility(8);
      }
      paramView = this.jdField_a_of_type_Affr.a(paramInt, localView, locala, localafmi);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (afgf.a)paramView.getTag();
      localView = paramView;
      break;
      label524:
      locala.aZ.setImageDrawable(localafmi.a(this.d.getApplicationContext(), this.mDensity, this.thumbWidth, this.thumbWidth));
      break label216;
      label559:
      locala.BH.setVisibility(0);
      locala.yF.setImageResource(2130846610);
      break label290;
      label582:
      locala.yF.setVisibility(8);
      break label307;
      label595:
      if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(paramView))) {
        paramView = paramView + "," + this.app.getApp().getString(2131691504);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 207)
    {
      Mq(((Integer)paramMessage.obj).intValue());
      notifyDataSetChanged();
      cZe();
      cZh();
    }
    do
    {
      do
      {
        return false;
        if (paramMessage.what == 206)
        {
          jU((List)paramMessage.obj);
          return false;
        }
      } while ((paramMessage.what != 208) || (!(paramMessage.obj instanceof Integer)));
      paramMessage = (Integer)paramMessage.obj;
      switch (paramMessage.intValue())
      {
      default: 
        return false;
      }
      QLog.e("FavEmosmViewPage", 1, new Object[] { "update ui, over limit flag:", Boolean.valueOf(CameraEmoAllSend.bXX), " ret:", paramMessage, " onResumed:", Boolean.valueOf(this.bXT) });
    } while ((CameraEmoAllSend.bXX) || (!this.bXT));
    CameraEmoAllSend.bXX = true;
    if (paramMessage.intValue() == 7) {}
    for (int i = 1;; i = 2)
    {
      afhf.a(this.app, this.d, i);
      return false;
    }
  }
  
  public void jU(List<afmi> paramList)
  {
    if ((!this.jdField_a_of_type_Affr.ajf()) && (paramList == null)) {
      return;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    afhv.a(this.app).cZG();
    if (this.cQK == 0) {
      if (this.jdField_a_of_type_Affr.ajf())
      {
        if (((List)localObject).size() == 0)
        {
          paramList = new afmi();
          paramList.operateType = 1;
          ((List)localObject).add(0, paramList);
        }
      }
      else
      {
        jW((List)localObject);
        jX((List)localObject);
      }
    }
    for (;;)
    {
      cZe();
      return;
      if (((afmi)((List)localObject).get(0)).operateType == 1) {
        break;
      }
      paramList = new afmi();
      paramList.operateType = 1;
      ((List)localObject).add(0, paramList);
      break;
      paramList = (List<afmi>)localObject;
      if (aji()) {
        paramList = aZ((List)localObject);
      }
      jW(paramList);
      paramList = this.jdField_a_of_type_Affr.aY(paramList);
      if (paramList != null) {
        jX(paramList);
      } else if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "reloadFavEmotionFinished favEmoList is null");
      }
    }
  }
  
  public void jV(List<afmi> paramList)
  {
    if (paramList == null) {
      return;
    }
    if ((this.jdField_a_of_type_Affr.zx != null) && (!this.jdField_a_of_type_Affr.zx.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_Affr.zx);
    }
    Object localObject;
    if ((this.jdField_a_of_type_Affr.ajf()) && (this.cQK == 0))
    {
      if (paramList.size() != 0) {
        break label139;
      }
      localObject = new afmi();
      ((afmi)localObject).operateType = 1;
      paramList.add(0, localObject);
    }
    for (;;)
    {
      afhv.a(this.app).cZG();
      localObject = paramList;
      if (aji()) {
        localObject = aZ(paramList);
      }
      this.zA = ((List)localObject);
      this.zB = ((List)localObject);
      this.mGridView.setAdapter(this);
      cZe();
      return;
      label139:
      if (((afmi)paramList.get(0)).operateType != 1)
      {
        localObject = new afmi();
        ((afmi)localObject).operateType = 1;
        paramList.add(0, localObject);
      }
    }
  }
  
  public void jW(List<afmi> paramList)
  {
    this.zA = paramList;
  }
  
  public void jX(List<afmi> paramList)
  {
    this.zB = paramList;
    super.notifyDataSetChanged();
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
      if (this.jdField_a_of_type_Affr.bXR)
      {
        anot.a(this.app, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
        this.d.finish();
      }
      else
      {
        cZa();
        continue;
        if (this.zB != null)
        {
          Iterator localIterator = this.zB.iterator();
          while (localIterator.hasNext())
          {
            afmi localafmi = (afmi)localIterator.next();
            if ((localafmi instanceof afpn)) {
              localafmi.isChecked = true;
            }
          }
          notifyDataSetChanged();
          cZe();
          anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
          continue;
          coN();
          continue;
          aqrf.a(this.app, this.d, "mvip.n.a.bqsc_edit", 3, "1450000516", "CJCLUBT", this.d.getString(2131720669), "");
          cZb();
          continue;
          cZc();
          cZe();
          QQToast.a(this.d.getApplicationContext(), this.d.getString(2131693057), 0).show();
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Affr.b(paramAdapterView, paramView, paramInt, paramLong)) {}
    String str;
    do
    {
      do
      {
        return;
        if (this.cQK != 0) {
          break;
        }
        if ((this.jdField_a_of_type_Affr.ajf()) && (paramInt == 0))
        {
          paramAdapterView = this.zB;
          if ((paramAdapterView != null) && (paramAdapterView.size() > 0) && (((afmi)paramAdapterView.get(0)).operateType == 1))
          {
            cZg();
            return;
          }
        }
        paramAdapterView = getItem(paramInt);
      } while (!(paramAdapterView instanceof afpn));
      paramAdapterView = (afpn)paramAdapterView;
      str = paramAdapterView.uy();
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "onItemClick roamingType = " + str);
      }
      if ((TextUtils.isEmpty(str)) || (!str.equals("needUpload"))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_NEED_UPLOAD");
    return;
    if ((!TextUtils.isEmpty(str)) && (str.equals("failed")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_FAILED");
      }
      this.jdField_a_of_type_Affr.a(this.mGridView, paramInt, paramAdapterView);
      return;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("needDownload")))
    {
      ah(paramView, paramInt);
      return;
    }
    paramAdapterView = (afgf.a)paramView.getTag();
    AIOEmotionFragment.a(this.d, (afmi)getItem(paramInt), sxx.getViewRect(paramAdapterView.aZ));
    return;
    paramAdapterView = getItem(paramInt);
    if ((paramAdapterView instanceof afmi))
    {
      paramAdapterView = (afmi)paramAdapterView;
      if (paramAdapterView.isChecked) {
        break label327;
      }
    }
    label327:
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.isChecked = bool;
      a(this.mGridView, paramInt);
      cZe();
      return;
    }
  }
  
  public void onPause()
  {
    this.bXT = false;
  }
  
  public void onResume()
  {
    this.bXT = true;
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (this.cQK == 0) {}
    do
    {
      do
      {
        return;
      } while (getCount() <= paramInt);
      localObject = getItem(paramInt);
    } while (!afpn.class.isInstance(localObject));
    Object localObject = (afpn)localObject;
    this.aTV = ((afpn)localObject).isChecked();
    if (!this.aTV) {}
    for (boolean bool = true;; bool = false)
    {
      ((afpn)localObject).HR(bool);
      this.mGridView.invalidateViews();
      this.aTU = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavEmosmViewPage", 2, "onSelectBegin");
      return;
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (this.cQK == 0) {}
    while (!this.aTU) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, new Object[] { "onSelectBegin beginIndex:", Integer.valueOf(paramInt1), "  selectIndex:", Integer.valueOf(paramInt2) });
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.mMinIndex > paramInt2)
      {
        this.mMinIndex = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label175;
        }
        localObject = getItem(paramInt1);
        if (afpn.class.isInstance(localObject)) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.mMaxIndex < paramInt2) {
        this.mMaxIndex = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    Object localObject = (afpn)localObject;
    if (!this.aTV) {}
    for (boolean bool = true;; bool = false)
    {
      ((afpn)localObject).HR(bool);
      break;
    }
    label175:
    paramInt1 = j + 1;
    if (paramInt1 <= this.mMaxIndex)
    {
      localObject = getItem(paramInt1);
      if (!afpn.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((afpn)localObject).HR(this.aTV);
      }
    }
    paramInt1 = this.mMinIndex;
    if (paramInt1 < i)
    {
      localObject = getItem(paramInt1);
      if (!afpn.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((afpn)localObject).HR(this.aTV);
      }
    }
    this.mGridView.invalidateViews();
    cZe();
  }
  
  public void onSelectEnd()
  {
    if (this.cQK == 0) {}
    while (!this.aTU) {
      return;
    }
    this.aTU = false;
    this.aTV = false;
    this.mMaxIndex = -2147483648;
    this.mMinIndex = 2147483647;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onSelectEnd");
    }
    cZe();
  }
  
  public void setTitle(int paramInt)
  {
    this.d.setTitle(paramInt);
  }
  
  public class a
  {
    public View BH;
    public View BI;
    public View BJ;
    public URLImageView aZ;
    public ImageView yF;
    public ImageView yG;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void db(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgf
 * JD-Core Version:    0.7.0.1
 */