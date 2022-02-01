import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class izc
{
  private boolean Wt;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  private izc.b jdField_a_of_type_Izc$b;
  int aqx = 0;
  private PinnedDividerListView b;
  View.OnClickListener ca = new izd(this);
  View.OnClickListener cb = new ize(this);
  LayoutInflater d = null;
  ArrayList<izc.a> iG = new ArrayList();
  private VideoAppInterface mApp;
  WeakReference<Context> mContext = null;
  long md = 0L;
  private boolean ni;
  
  @TargetApi(9)
  public izc(Context paramContext, VideoAppInterface paramVideoAppInterface, PinnedDividerListView paramPinnedDividerListView, long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mContext = new WeakReference(paramContext);
    this.b = paramPinnedDividerListView;
    this.md = paramLong;
    this.aqx = paramInt;
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "MVMembersContolUI-->can not get videoControl");
      }
      return;
    }
    this.d = LayoutInflater.from((Context)this.mContext.get());
    this.jdField_a_of_type_Izc$b = new izc.b(null);
    this.b.setAdapter(this.jdField_a_of_type_Izc$b);
    this.ni = paramBoolean;
    this.Wt = ThemeUtil.isInNightMode(this.mApp);
  }
  
  private void bD(ArrayList<VideoController.b> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource");
    }
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMemberListCtrl", 2, "refreshDataSource-->friends list is null");
      }
    }
    for (;;)
    {
      return;
      this.iG.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        VideoController.b localb = (VideoController.b)paramArrayList.get(i);
        izc.a locala = new izc.a(null);
        locala.uin = localb.uin;
        locala.Wu = localb.Pg;
        locala.accountType = localb.accountType;
        locala.b = localb.a;
        locala.Pk = localb.Pk;
        locala.Pl = localb.Pl;
        locala.Ww = localb.Pn;
        this.iG.add(locala);
        i += 1;
      }
    }
  }
  
  private int v(long paramLong)
  {
    int i = 0;
    while (i < this.iG.size())
    {
      if (((izc.a)this.iG.get(i)).uin == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void H(long paramLong, boolean paramBoolean)
  {
    int i = v(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",bSpeak=" + paramBoolean);
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              do
              {
                do
                {
                  return;
                  localObject = (izc.a)this.iG.get(i);
                  ((izc.a)localObject).Wu = paramBoolean;
                  if (((izc.a)localObject).Pk)
                  {
                    ((izc.a)localObject).Wu = false;
                    paramBoolean = false;
                  }
                  j = this.b.getFirstVisiblePosition();
                  int k = this.b.getLastVisiblePosition();
                  if ((i >= j) && (i <= k)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view is invisible uin =" + paramLong + " , index = " + i);
                return;
                j = i + 1 - j;
              } while (j > this.b.getChildCount());
              localObject = this.b.getChildAt(j);
              if (localObject != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view == null , index = " + i);
            return;
            if (((View)localObject).getTag() != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isSpeak=" + paramBoolean);
          return;
          localObject = (izc.c)((View)localObject).getTag();
        } while (localObject == null);
        if ((!paramBoolean) || (!((izc.c)localObject).Wx)) {
          break;
        }
        ((izc.c)localObject).gs.setVisibility(0);
      } while (((izc.c)localObject).hT == null);
      ((izc.c)localObject).hT.setVisibility(0);
      return;
      ((izc.c)localObject).gs.setVisibility(8);
    } while (((izc.c)localObject).hT == null);
    ((izc.c)localObject).hT.setVisibility(8);
  }
  
  public void asO()
  {
    boolean bool2 = false;
    int i = this.b.getFirstVisiblePosition();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int k = this.b.getLastVisiblePosition();
      int j = i;
      for (;;)
      {
        boolean bool1 = bool2;
        if (j < k)
        {
          bool1 = bool2;
          if (j < this.iG.size())
          {
            izc.a locala = (izc.a)this.iG.get(j);
            if ((locala == null) || (locala.Wv)) {
              break label146;
            }
            bool1 = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("GAudioMemberListCtrl", 2, "refreshHeadbitmap-->minIndex=" + i + ",maxIndex=" + k + ",needRefresh=" + bool1);
        }
        if (bool1) {
          this.jdField_a_of_type_Izc$b.notifyDataSetChanged();
        }
        return;
        label146:
        j += 1;
      }
    }
  }
  
  public void bC(ArrayList<VideoController.b> paramArrayList)
  {
    if (paramArrayList != null)
    {
      bD(paramArrayList);
      this.jdField_a_of_type_Izc$b.notifyDataSetChanged();
    }
  }
  
  public void c(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = v(paramLong);
    if (paramInt2 == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",isMicOff=" + paramBoolean);
      }
    }
    izc.a locala;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                int i;
                do
                {
                  return;
                  locala = (izc.a)this.iG.get(paramInt2);
                  locala.Pk = paramBoolean;
                  locala.accountType = paramInt1;
                  paramInt1 = this.b.getFirstVisiblePosition();
                  i = this.b.getLastVisiblePosition();
                } while ((paramInt2 < paramInt1) || (paramInt2 > i));
                paramInt1 = paramInt2 + 1 - paramInt1;
              } while (paramInt1 > this.b.getChildCount());
              localObject = this.b.getChildAt(paramInt1);
              if (localObject != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged--> view == null , index = " + paramInt2);
            return;
            if (((View)localObject).getTag() != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("GAudioMemberListCtrl", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + paramInt2 + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
          return;
          localObject = (izc.c)((View)localObject).getTag();
        } while (localObject == null);
        if (locala.Pk)
        {
          ((izc.c)localObject).gs.setVisibility(8);
          if (((izc.c)localObject).hT != null) {
            ((izc.c)localObject).hT.setVisibility(8);
          }
        }
        if (!locala.Pk) {
          break;
        }
      } while ((((izc.c)localObject).avO != -1) && (((izc.c)localObject).avO != 0));
      c(((izc.c)localObject).aF, locala.Pk);
      ((izc.c)localObject).avO = 1;
      return;
    } while ((((izc.c)localObject).avO != -1) && (((izc.c)localObject).avO != 1));
    c(((izc.c)localObject).aF, locala.Pk);
    ((izc.c)localObject).avO = 0;
  }
  
  void c(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.Wt) {}
      for (i = 2130842820;; i = 2130842819)
      {
        paramImageView.setImageResource(i);
        paramImageView.setContentDescription(acfp.m(2131706850));
        return;
      }
    }
    if (this.Wt) {}
    for (int i = 2130842822;; i = 2130842821)
    {
      paramImageView.setImageResource(i);
      paramImageView.setContentDescription(acfp.m(2131706852));
      return;
    }
  }
  
  public void m(long paramLong, boolean paramBoolean)
  {
    int i = v(paramLong);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMemberListCtrl", 2, "onSetMicBySelf uin=" + paramLong + ",isMicOffBySelf=" + paramBoolean);
      }
      return;
    }
    ((izc.a)this.iG.get(i)).Pl = paramBoolean;
  }
  
  public void onDestroy()
  {
    int j = this.b.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.b.getChildAt(i).setTag(null);
      i += 1;
    }
    this.b = null;
    this.jdField_a_of_type_Izc$b = null;
    this.mApp = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.d = null;
    if (this.iG != null) {
      this.iG.clear();
    }
    if (this.mContext != null) {
      this.mContext.clear();
    }
    this.mContext = null;
  }
  
  final class a
  {
    public boolean Pk;
    public boolean Pl;
    public String Ro;
    public boolean Wu;
    public boolean Wv;
    public boolean Ww = true;
    public int accountType;
    public AVPhoneUserInfo b;
    public Bitmap faceBitmap;
    public String name;
    public long uin;
    
    private a() {}
  }
  
  class b
    extends BaseAdapter
  {
    private b() {}
    
    izc.c a(View paramView, boolean paramBoolean)
    {
      izc.c localc = new izc.c(izc.this, null);
      localc.E = ((ImageView)paramView.findViewById(2131374006));
      localc.name = ((TextView)paramView.findViewById(2131374022));
      localc.mG = ((TextView)paramView.findViewById(2131374008));
      localc.aF = ((ImageView)paramView.findViewById(2131373995));
      localc.mH = ((TextView)paramView.findViewById(2131374027));
      localc.gs = ((ImageView)paramView.findViewById(2131374024));
      if (!izc.a(izc.this))
      {
        localc.aF.setVisibility(8);
        localc.aF.setEnabled(false);
        localc.aF.setClickable(false);
      }
      localc.aF.setOnClickListener(izc.this.cb);
      localc.Wy = paramBoolean;
      if (izc.b(izc.this))
      {
        paramView.setBackgroundColor(-16777216);
        localc.name.setTextColor(Color.parseColor("#A8A8A8"));
        localc.mH.setTextColor(Color.parseColor("#757575"));
        localc.hT = paramView.findViewById(2131374026);
        localc.hT.setBackgroundDrawable(jll.a(10.4F, (Context)izc.this.mContext.get()));
        paramView.findViewById(2131363675).setBackgroundColor(Color.parseColor("#0F0F0F"));
      }
      return localc;
    }
    
    public int getCount()
    {
      return izc.this.iG.size();
    }
    
    public Object getItem(int paramInt)
    {
      return izc.this.iG.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      izc.a locala = (izc.a)izc.this.iG.get(paramInt);
      Object localObject1;
      Object localObject2;
      label167:
      Object localObject3;
      if (paramView == null)
      {
        paramView = izc.this.d.inflate(2131559906, null);
        localObject1 = a(paramView, locala.Ww);
        paramView.setTag(localObject1);
        ((izc.c)localObject1).aF.setTag(locala);
        ((izc.c)localObject1).E.setTag(locala);
        if ((locala.name == null) || (locala.faceBitmap == null) || (!locala.Wv))
        {
          if (locala.accountType != 0) {
            break label616;
          }
          localObject2 = String.valueOf(locala.uin);
          locala.name = izc.this.a.d((String)localObject2, String.valueOf(izc.this.md), izc.this.aqx);
          if (locala.name.compareTo((String)localObject2) == 0) {
            break label592;
          }
          locala.Wv = true;
          localObject3 = izc.this.a.a((String)localObject2, String.valueOf(izc.this.md), izc.this.aqx, false, true);
          if (locala.Ww)
          {
            localObject2 = localObject3;
            if (!izc.b(izc.this)) {}
          }
          else
          {
            localObject2 = localObject3;
            if (localObject3 != null) {
              localObject2 = aqhu.b((Bitmap)localObject3, true);
            }
          }
          if (localObject2 == null) {
            break label601;
          }
          locala.faceBitmap = ((Bitmap)localObject2);
        }
        label251:
        ((izc.c)localObject1).Wx = true;
        ((izc.c)localObject1).uin = locala.uin;
        if (locala.name == null) {
          break label885;
        }
        float f = ((izc.c)localObject1).name.getResources().getDimensionPixelSize(2131297418);
        localObject2 = jll.a(((izc.c)localObject1).name.getContext(), locala.name, ((izc.c)localObject1).name, f);
        ((izc.c)localObject1).name.setText((CharSequence)localObject2);
        label326:
        if (locala.faceBitmap == null) {
          break label953;
        }
        if ((locala.accountType == 0) || (locala.Ro == null)) {
          break label904;
        }
        ((izc.c)localObject1).mG.setVisibility(0);
        ((izc.c)localObject1).mG.setText(locala.Ro);
        localObject2 = ((BitmapDrawable)((Context)izc.this.mContext.get()).getResources().getDrawable(2130842937)).getBitmap();
        ((izc.c)localObject1).E.setImageBitmap((Bitmap)localObject2);
        label412:
        if (!locala.Pk) {
          break label977;
        }
        if ((((izc.c)localObject1).avO == -1) || (((izc.c)localObject1).avO == 0))
        {
          izc.this.c(((izc.c)localObject1).aF, locala.Pk);
          ((izc.c)localObject1).avO = 1;
        }
        locala.Wu = false;
        label466:
        ((izc.c)localObject1).Pg = locala.Wu;
        if (!((izc.c)localObject1).Pg) {
          break label1021;
        }
        ((izc.c)localObject1).gs.setVisibility(0);
        if (((izc.c)localObject1).hT != null) {
          ((izc.c)localObject1).hT.setVisibility(0);
        }
        label510:
        if (locala.Ww) {
          break label1052;
        }
        ((izc.c)localObject1).mH.setVisibility(0);
        ((izc.c)localObject1).aF.setVisibility(8);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject2 = (izc.c)paramView.getTag();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a(paramView, locala.Ww);
          paramView.setTag(localObject1);
        }
        break;
        label592:
        locala.Wv = false;
        break label167;
        label601:
        locala.faceBitmap = null;
        locala.Wv = false;
        break label251;
        label616:
        long l = locala.uin;
        if (locala.b != null)
        {
          localObject2 = locala.b;
          label638:
          if ((localObject2 == null) || (((AVPhoneUserInfo)localObject2).telInfo.mobile == null)) {
            break label807;
          }
          locala.name = ((AVPhoneUserInfo)localObject2).telInfo.mobile;
          localObject3 = izc.this.a.dd(((AVPhoneUserInfo)localObject2).telInfo.mobile);
          if (localObject3 == null) {
            break label781;
          }
          locala.Ro = aqgv.ps((String)localObject3);
          locala.name = ((String)localObject3);
        }
        for (;;)
        {
          locala.faceBitmap = ((BitmapDrawable)((Context)izc.this.mContext.get()).getResources().getDrawable(2130842980)).getBitmap();
          locala.Wv = true;
          break;
          localObject2 = izc.this.a.a(l, izc.this.a.b().ii);
          break label638;
          label781:
          locala.Ro = null;
          locala.name = jkm.v(((AVPhoneUserInfo)localObject2).telInfo.mobile, 4);
          continue;
          label807:
          if ((localObject2 != null) && (QLog.isColorLevel())) {
            QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject2).toString());
          }
          locala.Ro = null;
          locala.name = ((Context)izc.this.mContext.get()).getResources().getString(2131694561);
        }
        label885:
        ((izc.c)localObject1).name.setText(String.valueOf(locala.uin));
        break label326;
        label904:
        ((izc.c)localObject1).mG.setVisibility(8);
        ((izc.c)localObject1).E.setImageBitmap(locala.faceBitmap);
        if (locala.accountType != 0) {
          break label412;
        }
        ((izc.c)localObject1).E.setOnClickListener(izc.this.ca);
        break label412;
        label953:
        ((izc.c)localObject1).mG.setVisibility(8);
        ((izc.c)localObject1).E.setImageResource(2130840645);
        break label412;
        label977:
        if ((((izc.c)localObject1).avO != -1) && (((izc.c)localObject1).avO != 1)) {
          break label466;
        }
        izc.this.c(((izc.c)localObject1).aF, locala.Pk);
        ((izc.c)localObject1).avO = 0;
        break label466;
        label1021:
        ((izc.c)localObject1).gs.setVisibility(8);
        if (((izc.c)localObject1).hT == null) {
          break label510;
        }
        ((izc.c)localObject1).hT.setVisibility(8);
        break label510;
        label1052:
        if (izc.a(izc.this)) {
          ((izc.c)localObject1).aF.setVisibility(0);
        }
        ((izc.c)localObject1).mH.setVisibility(8);
      }
    }
  }
  
  final class c
  {
    ImageView E = null;
    boolean Pg = false;
    boolean Wx = true;
    public boolean Wy = true;
    ImageView aF = null;
    public int avO = -1;
    ImageView gs = null;
    View hT = null;
    TextView mG = null;
    TextView mH = null;
    TextView name = null;
    long uin;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izc
 * JD-Core Version:    0.7.0.1
 */