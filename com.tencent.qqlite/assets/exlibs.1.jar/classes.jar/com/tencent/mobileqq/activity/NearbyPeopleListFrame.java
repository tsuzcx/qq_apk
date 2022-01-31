package com.tencent.mobileqq.activity;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Message;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import aww;
import awx;
import awy;
import awz;
import axd;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.NearbyFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class NearbyPeopleListFrame
  extends NearbyFrame
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public static final int a = 1000;
  public static String a;
  static final int jdField_b_of_type_Int = 30000;
  private static final String jdField_b_of_type_JavaLangString = "NearbyPeopleListFrame";
  public static final int c = 0;
  static final long jdField_c_of_type_Long = 1000L;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 4;
  public static int g = 0;
  public static int p = 1;
  public static int q = 2;
  public static int r = 100;
  static final int u = 0;
  static final int v = 1;
  static final int w = 1;
  private int A = 0;
  public long a;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private axd jdField_a_of_type_Axd = new axd(this, this);
  public NearPeopleFilterActivity.NearPeopleFilters a;
  public PeopleAroundAdapter a;
  private LBSHandler jdField_a_of_type_ComTencentMobileqqAppLBSHandler;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new awz(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new awx(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public PullRefreshHeader a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new awy(this);
  public XListView a;
  public List a;
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt;
  long[] jdField_a_of_type_ArrayOfLong;
  public long b;
  private View jdField_b_of_type_AndroidViewView;
  protected boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private View d;
  private View e;
  private boolean f = false;
  int h;
  public int i;
  protected int j = 0;
  protected int k = 0;
  protected int l = 0;
  public int m = 0;
  public int n = 0;
  protected int o = 0;
  protected int s = 0;
  protected int t = 4;
  
  static
  {
    jdField_a_of_type_JavaLangString = "source";
  }
  
  public NearbyPeopleListFrame()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramInt1, a().getString(paramInt2), 0).b((int)this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getResources().getDimension(2131492887));
  }
  
  private void a(int paramInt, String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, paramInt, paramString, 0).b((int)this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getResources().getDimension(2131492887));
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(a(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.A == 0) {
      this.A = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.A, this.A);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = 8;
    TextView localTextView = (TextView)this.d.findViewById(2131297311);
    ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131296561);
    ImageView localImageView = (ImageView)this.d.findViewById(2131297310);
    if (paramBoolean)
    {
      i1 = 2131364192;
      localTextView.setText(i1);
      if (!paramBoolean) {
        break label89;
      }
      i1 = 0;
      label64:
      localProgressBar.setVisibility(i1);
      if (!paramBoolean) {
        break label95;
      }
    }
    label89:
    label95:
    for (int i1 = i2;; i1 = 0)
    {
      localImageView.setVisibility(i1);
      return;
      i1 = 2131363206;
      break;
      i1 = 8;
      break label64;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeopleListFrame", 2, "doRefreshList last request is in process... return");
      }
      return;
    }
    int i3 = b();
    byte b5 = (byte)this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l;
    int i2 = 480;
    int i1;
    label59:
    byte b3;
    byte b4;
    byte b1;
    byte b2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j == 0)
    {
      i1 = 480;
      b3 = 0;
      b4 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k != 0) {
        break label348;
      }
      b1 = 0;
      b2 = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.j != 0)
      {
        localObject1 = localObject2;
        if (this.k != 0) {
          localObject1 = new GeoPoint(this.j, this.k);
        }
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i3, paramBoolean, null, (GeoPoint)localObject1, this.o, b5, i1, b1, b2, this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.m, ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.c[0]), ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.c[1]), ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.c[2]), null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NearbyPeopleListFrame", 2, "doRefreshList mRequestId=" + this.jdField_b_of_type_Long);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j == 1)
      {
        i1 = 30;
        break label59;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j == 2)
      {
        i1 = 60;
        break label59;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j == 3)
      {
        i1 = 240;
        break label59;
      }
      i1 = i2;
      if (!QLog.isColorLevel()) {
        break label59;
      }
      QLog.d("NearbyPeopleListFrame", 2, "doRefreshList time is unknown.mFilter.time=" + this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j);
      i1 = i2;
      break label59;
      label348:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k == 1)
      {
        b1 = 18;
        b2 = 22;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k == 2)
      {
        b1 = 23;
        b2 = 26;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k == 3)
      {
        b1 = 27;
        b2 = 35;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k == 4)
      {
        b1 = 36;
        b2 = 127;
      }
      else
      {
        b1 = b3;
        b2 = b4;
        if (QLog.isColorLevel())
        {
          QLog.d("NearbyPeopleListFrame", 2, "doRefreshList agetype is unknown.mFilter.age=" + this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k);
          b1 = b3;
          b2 = b4;
        }
      }
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return paramLayoutInflater.inflate(2130903510, null);
  }
  
  short a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return -1;
    }
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject == null) {
      return -1;
    }
    localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (localObject == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleListFrame", 2, "getMyGender.gender=" + ((Card)localObject).shGender);
    }
    return ((Card)localObject).shGender;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131298221));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getLayoutInflater().inflate(2130903352, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(a().getDimensionPixelSize(2131492882));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837660);
    this.e = a(2131297721);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getLayoutInflater().inflate(2130903511, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131298270);
    this.d = this.jdField_b_of_type_AndroidViewView.findViewById(2131298271);
    this.d.setOnClickListener(new aww(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter = new PeopleAroundAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == r) {
      if (paramInt2 == -1)
      {
        localObject = new NearPeopleFilterActivity.NearPeopleFilters();
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).i = paramIntent.getIntExtra("gender", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).j = paramIntent.getIntExtra("time", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).k = paramIntent.getIntExtra("age", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).l = paramIntent.getIntExtra("xingzuo", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).m = paramIntent.getIntExtra("key_career", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[0] = paramIntent.getStringExtra("key_hometown_country");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[1] = paramIntent.getStringExtra("key_hometown_province");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).c[2] = paramIntent.getStringExtra("key_hometown_city");
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = ((NearPeopleFilterActivity.NearPeopleFilters)localObject);
        a(true, false);
      }
    }
    String str;
    byte b1;
    byte b2;
    byte b3;
    int i1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 != 1000) {
              break;
            }
          } while (paramInt2 != -1);
          localObject = paramIntent.getByteArrayExtra("param_xuan_yan");
          str = paramIntent.getStringExtra("param_nickname");
          b1 = paramIntent.getByteExtra("param_gender", (byte)-1);
          paramInt1 = paramIntent.getIntExtra("param_age", 0);
          paramInt2 = paramIntent.getIntExtra("param_career", 0);
          b2 = paramIntent.getByteExtra("param_constellation", (byte)0);
          b3 = paramIntent.getByteExtra("param_marital_status", (byte)0);
          i1 = paramIntent.getIntExtra("param_photo_count", 0);
        } while ((this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() <= 0));
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.get(0);
      } while (!(paramIntent instanceof RespEncounterInfo));
      paramIntent = (RespEncounterInfo)paramIntent;
    } while ((paramIntent.lEctID <= 0L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(paramIntent.lEctID))));
    if (paramIntent.richState == null) {
      paramIntent.richState = new RishState();
    }
    paramIntent.richState.vState = ((byte[])localObject);
    paramIntent.strNick = str;
    paramIntent.cSex = b1;
    paramIntent.cAge = ((byte)paramInt1);
    paramIntent.profession_id = paramInt2;
    paramIntent.constellation = b2;
    paramIntent.marriage = b3;
    paramIntent.nFaceNum = i1;
    return;
    a(true, false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.refresh_head", 2, "uin=" + paramString + ", type=" + paramInt2);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {}
    label176:
    for (;;)
    {
      return;
      int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= i1) {
          break label176;
        }
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (PeopleAroundAdapter.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (paramInt2 == ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_Int) && (paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.nearby_people_card.refresh_head", 2, "face updated, uin=" + paramString);
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
    } while (paramInt != 0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  /* Error */
  public void a(String paramString1, List paramList, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 610	java/io/ObjectOutputStream
    //   6: dup
    //   7: aload_0
    //   8: getfield 148	com/tencent/mobileqq/activity/NearbyPeopleListFrame:jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity	Lcom/tencent/mobileqq/activity/NearbyActivity;
    //   11: new 305	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   18: aload_1
    //   19: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 612
    //   25: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: iconst_0
    //   32: invokevirtual 616	com/tencent/mobileqq/activity/NearbyActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   35: invokespecial 619	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   38: astore_3
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: aload_2
    //   43: invokevirtual 622	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   46: aload_3
    //   47: astore_1
    //   48: aload_3
    //   49: aload_0
    //   50: getfield 624	com/tencent/mobileqq/activity/NearbyPeopleListFrame:jdField_a_of_type_Long	J
    //   53: invokevirtual 628	java/io/ObjectOutputStream:writeLong	(J)V
    //   56: aload_3
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 631	java/io/ObjectOutputStream:flush	()V
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 634	java/io/ObjectOutputStream:close	()V
    //   70: return
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   76: return
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: astore_1
    //   83: aload 4
    //   85: invokevirtual 638	java/lang/Exception:printStackTrace	()V
    //   88: aload_2
    //   89: ifnull -19 -> 70
    //   92: aload_2
    //   93: invokevirtual 634	java/io/ObjectOutputStream:close	()V
    //   96: return
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   102: return
    //   103: astore_1
    //   104: aload 4
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 634	java/io/ObjectOutputStream:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_2
    //   118: aload_2
    //   119: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_3
    //   126: aload_1
    //   127: astore_2
    //   128: aload_3
    //   129: astore_1
    //   130: goto -23 -> 107
    //   133: astore 4
    //   135: aload_3
    //   136: astore_2
    //   137: goto -56 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	NearbyPeopleListFrame
    //   0	140	1	paramString1	String
    //   0	140	2	paramList	List
    //   0	140	3	paramString2	String
    //   1	1	4	localObject	Object
    //   77	28	4	localException1	java.lang.Exception
    //   133	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   66	70	71	java/io/IOException
    //   3	39	77	java/lang/Exception
    //   92	96	97	java/io/IOException
    //   3	39	103	finally
    //   111	115	117	java/io/IOException
    //   41	46	125	finally
    //   48	56	125	finally
    //   58	62	125	finally
    //   83	88	125	finally
    //   41	46	133	java/lang/Exception
    //   48	56	133	java/lang/Exception
    //   58	62	133	java/lang/Exception
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_c_of_type_Boolean) {
      a(0, 1, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Axd.removeMessages(0);
      if (paramBoolean2) {
        o();
      }
    }
    while (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity))
    {
      c(paramBoolean1);
      return;
      n();
      continue;
      b(true);
    }
    Message localMessage = this.jdField_a_of_type_Axd.obtainMessage(1, 1, 0);
    this.jdField_a_of_type_Axd.sendMessageDelayed(localMessage, 1000L);
  }
  
  /* Error */
  protected boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 663	java/io/ObjectInputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 148	com/tencent/mobileqq/activity/NearbyPeopleListFrame:jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity	Lcom/tencent/mobileqq/activity/NearbyActivity;
    //   10: new 305	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   17: aload_1
    //   18: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 612
    //   24: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 667	com/tencent/mobileqq/activity/NearbyActivity:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   33: invokespecial 670	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 673	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: checkcast 506	java/util/List
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +31 -> 79
    //   51: aload_2
    //   52: astore_1
    //   53: aload_0
    //   54: aload_3
    //   55: putfield 90	com/tencent/mobileqq/activity/NearbyPeopleListFrame:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 438	com/tencent/mobileqq/activity/NearbyPeopleListFrame:jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter	Lcom/tencent/mobileqq/adapter/PeopleAroundAdapter;
    //   64: aload_3
    //   65: iconst_0
    //   66: invokevirtual 676	com/tencent/mobileqq/adapter/PeopleAroundAdapter:a	(Ljava/util/List;Z)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_0
    //   72: aload_2
    //   73: invokevirtual 680	java/io/ObjectInputStream:readLong	()J
    //   76: putfield 624	com/tencent/mobileqq/activity/NearbyPeopleListFrame:jdField_a_of_type_Long	J
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_2
    //   84: invokevirtual 681	java/io/ObjectInputStream:close	()V
    //   87: aload_0
    //   88: getfield 438	com/tencent/mobileqq/activity/NearbyPeopleListFrame:jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter	Lcom/tencent/mobileqq/adapter/PeopleAroundAdapter;
    //   91: invokevirtual 602	com/tencent/mobileqq/adapter/PeopleAroundAdapter:notifyDataSetChanged	()V
    //   94: iconst_0
    //   95: ireturn
    //   96: astore_3
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: invokevirtual 638	java/lang/Exception:printStackTrace	()V
    //   103: goto -24 -> 79
    //   106: astore_3
    //   107: aload_2
    //   108: astore_1
    //   109: aload_3
    //   110: invokevirtual 638	java/lang/Exception:printStackTrace	()V
    //   113: aload_2
    //   114: ifnull -27 -> 87
    //   117: aload_2
    //   118: invokevirtual 681	java/io/ObjectInputStream:close	()V
    //   121: goto -34 -> 87
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   129: goto -42 -> 87
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   137: goto -50 -> 87
    //   140: astore_1
    //   141: aload_3
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 681	java/io/ObjectInputStream:close	()V
    //   151: aload_1
    //   152: athrow
    //   153: astore_2
    //   154: aload_2
    //   155: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   158: goto -7 -> 151
    //   161: astore_3
    //   162: aload_1
    //   163: astore_2
    //   164: aload_3
    //   165: astore_1
    //   166: goto -23 -> 143
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_2
    //   172: goto -65 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	NearbyPeopleListFrame
    //   0	175	1	paramString	String
    //   36	112	2	localObject1	Object
    //   153	2	2	localIOException	java.io.IOException
    //   163	9	2	str	String
    //   1	64	3	localList	List
    //   96	4	3	localException1	java.lang.Exception
    //   106	36	3	localException2	java.lang.Exception
    //   161	4	3	localObject2	Object
    //   169	1	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   71	79	96	java/lang/Exception
    //   39	47	106	java/lang/Exception
    //   53	58	106	java/lang/Exception
    //   60	69	106	java/lang/Exception
    //   99	103	106	java/lang/Exception
    //   117	121	124	java/io/IOException
    //   83	87	132	java/io/IOException
    //   2	37	140	finally
    //   147	151	153	java/io/IOException
    //   39	47	161	finally
    //   53	58	161	finally
    //   60	69	161	finally
    //   71	79	161	finally
    //   99	103	161	finally
    //   109	113	161	finally
    //   2	37	169	java/lang/Exception
  }
  
  public int b()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 2;
    }
    return 1;
  }
  
  public void b()
  {
    if (!this.f)
    {
      this.f = true;
      j();
    }
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004440", "0X8004440", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeopleListFrame", 2, "NearbyPeopleListFrame onTabSlideComplete");
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
    Object localObject = this.jdField_a_of_type_Axd;
    if (paramBoolean1) {}
    for (int i1 = 0;; i1 = 1)
    {
      localObject = ((axd)localObject).obtainMessage(0, i1, 0);
      this.jdField_a_of_type_Axd.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
  }
  
  protected void d()
  {
    super.d();
    a(0, 1, false);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.k();
  }
  
  public void f() {}
  
  void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = NearPeopleFilterActivity.NearPeopleFilters.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j = 4;
      if (a() != 0) {
        break label116;
      }
    }
    label116:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i = 2;; this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i = 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.a())
      {
        this.jdField_c_of_type_Boolean = true;
        a(0, 1, true);
      }
      a(true, false);
      return;
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(0, 2131364443);
      return;
    }
    a(new Intent(a(), NearPeopleFilterActivity.class), r);
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004441", "0X8004441", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    paramView = (PeopleAroundAdapter.ViewHolder)paramView.getTag();
    if (paramView != null) {}
    for (paramView = paramView.jdField_a_of_type_EncounterSvcRespEncounterInfo;; paramView = null)
    {
      Object localObject1;
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof RespEncounterInfo)))
      {
        paramView = (RespEncounterInfo)paramView;
        localObject1 = String.valueOf(paramView.lEctID);
        localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((paramView.lEctID <= 0L) || (localObject2 == null)) {
          break label574;
        }
      }
      label574:
      for (boolean bool = ((FriendManager)localObject2).b((String)localObject1);; bool = false)
      {
        if (((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 0);
          ((ProfileActivity.AllInOne)localObject1).h = paramView.strNick;
          ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramView.cAge;
          ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramView.cSex;
          ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramView.wFace;
          ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Byte = paramView.marriage;
          ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_Int = paramView.profession_id;
          ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_Byte = paramView.constellation;
          ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_ArrayOfByte = paramView.richState.vState;
          ((ProfileActivity.AllInOne)localObject1).f = this.t;
          ((ProfileActivity.AllInOne)localObject1).g = 5;
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, NearbyPeopleProfileActivity.class);
          ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
          ((Intent)localObject2).putExtra("param_mode", 2);
          ((Intent)localObject2).putExtra("param_tiny_id", paramView.tiny_id);
          a((Intent)localObject2, 1000);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800482F", "0X800482F", 0, 0, "1", "", "", "");
          return;
        }
        if (bool)
        {
          localObject1 = new ProfileActivity.AllInOne((String)localObject1, 40);
          ((ProfileActivity.AllInOne)localObject1).h = paramView.strNick;
          ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramView.cAge;
          ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramView.cSex;
          ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramView.wFace;
          ((ProfileActivity.AllInOne)localObject1).f = this.t;
          ((ProfileActivity.AllInOne)localObject1).g = 5;
          ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, (ProfileActivity.AllInOne)localObject1);
          return;
        }
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 41);
        ((ProfileActivity.AllInOne)localObject1).h = paramView.strNick;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Int = paramView.cAge;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Byte = paramView.cSex;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_Short = paramView.wFace;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_Byte = paramView.marriage;
        ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_Int = paramView.profession_id;
        ((ProfileActivity.AllInOne)localObject1).jdField_c_of_type_Byte = paramView.constellation;
        ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_ArrayOfByte = paramView.richState.vState;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_JavaLangString = paramView.strDescription;
        ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_ArrayOfByte = paramView.sig;
        ((ProfileActivity.AllInOne)localObject1).o = paramView.enc_id;
        ((ProfileActivity.AllInOne)localObject1).p = paramView.uid;
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "附近人列表accost_uin = " + ((ProfileActivity.AllInOne)localObject1).jdField_a_of_type_JavaLangString + "accost_sig = " + ((ProfileActivity.AllInOne)localObject1).jdField_b_of_type_ArrayOfByte);
        }
        ((ProfileActivity.AllInOne)localObject1).f = this.t;
        ((ProfileActivity.AllInOne)localObject1).g = 5;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, NearbyPeopleProfileActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("param_mode", 3);
        ((Intent)localObject2).putExtra("param_tiny_id", paramView.tiny_id);
        a((Intent)localObject2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyPeopleListFrame
 * JD-Core Version:    0.7.0.1
 */