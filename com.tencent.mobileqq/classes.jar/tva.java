import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class tva
  extends BaseAdapter
  implements aobv, tvo
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e = 1;
  private static int h;
  private float jdField_a_of_type_Float;
  private alby jdField_a_of_type_Alby;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<twg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tvl jdField_a_of_type_Tvl;
  private tvx jdField_a_of_type_Tvx;
  public boolean a;
  private float jdField_b_of_type_Float;
  private List<ReadInJoyArticle> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  private float jdField_c_of_type_Float;
  private List<Object> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  public int f = -1;
  public int g = -1;
  private final int i = 10;
  private int j;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    h = 3;
  }
  
  public tva(Activity paramActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_Alby = new alby(paramQQAppInterface, this, false);
    this.jdField_c_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297920);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297922);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297921);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297919);
  }
  
  private void a(tvc paramtvc, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramtvc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Alby.a(1008, paramString));
      return;
    }
    paramtvc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {
      bcst.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.jdField_a_of_type_JavaUtilHashSet.size(), 0, "", "", "", "");
    }
    if (this.j > 0) {
      bcst.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.j, 0, "", "", "", "");
    }
    if (this.jdField_d_of_type_Boolean) {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_Tvl = null;
    this.jdField_a_of_type_Tvx = null;
    this.jdField_a_of_type_Alby.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List<twg> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(tvl paramtvl)
  {
    this.jdField_a_of_type_Tvl = paramtvl;
  }
  
  public void a(tvx paramtvx)
  {
    this.jdField_a_of_type_Tvx = paramtvx;
  }
  
  public boolean a(ImageView paramImageView)
  {
    if (paramImageView.getTag(2131378064).equals(Integer.valueOf(jdField_b_of_type_Int))) {
      return true;
    }
    if (paramImageView.getTag(2131378064).equals(Integer.valueOf(jdField_a_of_type_Int)))
    {
      int m = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int k = 0;
      if (k < m)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(k).getTag();
        if ((localObject == null) || (!(localObject instanceof tvc))) {}
        while (!((tvc)localObject).jdField_a_of_type_JavaLangString.equals(paramImageView.getTag(2131378065)))
        {
          k += 1;
          break;
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    int m = 1;
    int k;
    if ((this.f == 1) && (this.jdField_a_of_type_Boolean))
    {
      k = 1;
      if ((this.g != 1) || (!this.jdField_b_of_type_Boolean)) {
        break label136;
      }
      label34:
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      if ((k != 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        if (this.jdField_c_of_type_JavaUtilList.size() > 6) {
          break label141;
        }
        this.jdField_c_of_type_JavaUtilList.add("ReadInJoyArticle");
      }
    }
    for (;;)
    {
      if (m != 0)
      {
        if (this.jdField_c_of_type_JavaUtilList.size() > 3) {
          break label158;
        }
        this.jdField_c_of_type_JavaUtilList.add("SubscriptRecommendController");
      }
      return;
      k = 0;
      break;
      label136:
      m = 0;
      break label34;
      label141:
      this.jdField_c_of_type_JavaUtilList.add(6, "ReadInJoyArticle");
    }
    label158:
    this.jdField_c_of_type_JavaUtilList.add(3, "SubscriptRecommendController");
  }
  
  public void b(List<ReadInJoyArticle> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_c_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_c_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int k = h;
    Object localObject = this.jdField_c_of_type_JavaUtilList.get(paramInt);
    if ((localObject instanceof twg)) {
      paramInt = jdField_a_of_type_Int;
    }
    do
    {
      do
      {
        return paramInt;
        if (((localObject instanceof String)) && (localObject.equals("SubscriptRecommendController"))) {
          return jdField_c_of_type_Int;
        }
        paramInt = k;
      } while (!(localObject instanceof String));
      paramInt = k;
    } while (!localObject.equals("ReadInJoyArticle"));
    return jdField_b_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramInt < 0) || (paramInt >= this.jdField_c_of_type_JavaUtilList.size()))
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    int m = getItemViewType(paramInt);
    Object localObject2 = null;
    int k;
    if (paramView == null) {
      if (m == jdField_a_of_type_Int)
      {
        localObject2 = new tvc(this);
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560363, null);
        ((tvc)localObject2).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131378053));
        ((tvc)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131378067));
        ((tvc)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378072));
        ((tvc)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131376355));
        ((tvc)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131380253));
        ((tvc)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131366445));
        ((tvc)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131366417));
        ((tvc)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131366421));
        ((tvc)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131370655));
        ((tvc)localObject2).jdField_b_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131370661));
        ((tvc)localObject2).jdField_c_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131370660));
        ((tvc)localObject2).d = ((Button)((View)localObject1).findViewById(2131370640));
        ((tvc)localObject2).jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((tvc)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, (View)localObject1);
        ((tvc)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((tvc)localObject2).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((tvc)localObject2).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((tvc)localObject2).jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((tvc)localObject2).d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView = ((tvc)localObject2).jdField_c_of_type_AndroidWidgetTextView;
        if (this.jdField_c_of_type_Boolean)
        {
          k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166059);
          label382:
          paramView.setTextColor(k);
          paramView = ((tvc)localObject2).jdField_a_of_type_AndroidWidgetTextView;
          if (!this.jdField_c_of_type_Boolean) {
            break label493;
          }
          k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166065);
          label413:
          paramView.setTextColor(k);
          paramView = ((tvc)localObject2).jdField_b_of_type_AndroidWidgetTextView;
          if (!this.jdField_c_of_type_Boolean) {
            break label508;
          }
          k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166068);
          label444:
          paramView.setTextColor(k);
          label450:
          paramView = (View)localObject1;
          if (localObject1 != null)
          {
            ((View)localObject1).setTag(localObject2);
            paramView = (View)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        localObject1 = null;
        break;
        k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166058);
        break label382;
        label493:
        k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166064);
        break label413;
        label508:
        k = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166067);
        break label444;
        if (m == jdField_b_of_type_Int)
        {
          localObject2 = new tvd(this, null);
          localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560365, null);
          ((tvd)localObject2).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131369421));
          ((tvd)localObject2).jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView = (TextView)((tvd)localObject2).jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369422);
          int n;
          if (!this.jdField_c_of_type_Boolean)
          {
            k = 2130843161;
            paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, k, 0);
            ((tvd)localObject2).jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)((View)localObject1).findViewById(2131369404));
            ((tvd)localObject2).jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)((View)localObject1).findViewById(2131369405));
            ((tvd)localObject2).jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)((View)localObject1).findViewById(2131369406));
            ((tvd)localObject2).jdField_a_of_type_JavaUtilArrayList.add((ViewGroup)((View)localObject1).findViewById(2131369407));
            n = ((tvd)localObject2).jdField_a_of_type_JavaUtilArrayList.size();
            paramView = this.jdField_a_of_type_AndroidContentResResources;
            if (this.jdField_c_of_type_Boolean) {
              break label807;
            }
          }
          label807:
          for (k = 2131166074;; k = 2131166075)
          {
            int i1 = paramView.getColor(k);
            k = 0;
            while (k < n)
            {
              paramView = (ViewGroup)((tvd)localObject2).jdField_a_of_type_JavaUtilArrayList.get(k);
              paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramView.setTag(Integer.valueOf(k));
              ((TextView)paramView.findViewById(2131362973)).setTextColor(i1);
              k += 1;
            }
            k = 2130843162;
            break;
          }
          ((View)localObject1).setTag(-3, Integer.valueOf(0));
          break label450;
        }
        if (m != jdField_c_of_type_Int) {
          break label2150;
        }
        localObject2 = new tve(this, null);
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560367, null);
        this.jdField_a_of_type_Tvx.a((View)localObject1);
        this.jdField_a_of_type_Tvx.b();
        this.jdField_a_of_type_Tvx.h();
        ((View)localObject1).setTag(-3, Integer.valueOf(0));
        this.jdField_d_of_type_Boolean = true;
        break label450;
      }
      Object localObject3;
      label1016:
      Object localObject4;
      if (m == jdField_a_of_type_Int)
      {
        paramView.setTag(2131378059, Integer.valueOf(paramInt));
        localObject1 = (tvc)paramView.getTag();
        localObject2 = (twg)getItem(paramInt);
        if (this.jdField_a_of_type_JavaUtilHashSet != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(((twg)localObject2).jdField_a_of_type_JavaLangString);
        }
        ((tvc)localObject1).jdField_a_of_type_JavaLangString = ((twg)localObject2).jdField_a_of_type_JavaLangString;
        a((tvc)localObject1, ((twg)localObject2).jdField_a_of_type_JavaLangString);
        localObject3 = twi.a().a(((twg)localObject2).jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          ((tvc)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((twg)localObject2).jdField_a_of_type_JavaLangString);
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(TimeManager.getInstance().getMsgDisplayTime(((twg)localObject2).jdField_a_of_type_JavaLangString, ((twg)localObject2).jdField_a_of_type_Long));
          if (((twg)localObject2).jdField_b_of_type_Int <= 0) {
            break label1417;
          }
          k = 3;
          label1051:
          bkjh.a(((tvc)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, ((twg)localObject2).jdField_b_of_type_Int, 2130850392, 99, null);
          if (((twg)localObject2).jdField_a_of_type_JavaUtilList.size() <= 0) {
            break label1799;
          }
          localObject4 = (twh)((twg)localObject2).jdField_a_of_type_JavaUtilList.get(0);
          if (((twh)localObject4).jdField_a_of_type_Int != 0) {
            break label1423;
          }
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(new bdnt(((twh)localObject4).c.replaceFirst("^\\s+", ""), 3, 20));
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          label1169:
          ((tvc)localObject1).jdField_a_of_type_AndroidViewViewGroup.setTag(2131378056, Integer.valueOf(((twg)localObject2).jdField_b_of_type_Int));
          ((tvc)localObject1).jdField_a_of_type_AndroidViewViewGroup.setTag(2131378065, ((twg)localObject2).jdField_a_of_type_JavaLangString);
          ((tvc)localObject1).jdField_a_of_type_AndroidViewViewGroup.setTag(2131378058, localObject3);
          ((tvc)localObject1).jdField_a_of_type_AndroidViewViewGroup.setTag(2131378057, Integer.valueOf(jdField_d_of_type_Int));
          ((tvc)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131378056, localObject2);
          ((tvc)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(2131378065, ((twg)localObject2).jdField_a_of_type_JavaLangString);
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetButton.setTag(2131378065, ((twg)localObject2).jdField_a_of_type_JavaLangString);
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetButton.setTag(2131378065, ((twg)localObject2).jdField_a_of_type_JavaLangString);
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetButton.setTag(2131378058, localObject3);
          ((tvc)localObject1).d.setTag(2131378065, ((twg)localObject2).jdField_a_of_type_JavaLangString);
          if (twi.a().a(((twg)localObject2).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label1838;
          }
          if (this.jdField_c_of_type_Boolean) {
            break label1824;
          }
          ((tvc)localObject1).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843157);
          label1355:
          paramView.setTag(-3, Integer.valueOf((int)(this.jdField_a_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          ((tvc)localObject1).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        ((tvc)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        break label1016;
        label1417:
        k = 0;
        break label1051;
        label1423:
        ViewGroup.LayoutParams localLayoutParams;
        if (((twh)localObject4).jdField_a_of_type_Int == 1)
        {
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(((twh)localObject4).b.replaceFirst("^\\s+", ""));
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          if (TextUtils.isEmpty(((twh)localObject4).g)) {
            ((tvc)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          for (;;)
          {
            ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(2131378065, ((tvc)localObject1).jdField_a_of_type_JavaLangString);
            ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(2131378064, Integer.valueOf(jdField_a_of_type_Int));
            localLayoutParams = ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
            this.jdField_a_of_type_Tvl.a(tyc.a(((twh)localObject4).jdField_a_of_type_JavaLangString, 1, ((twg)localObject2).jdField_a_of_type_JavaLangString), ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView, localLayoutParams.width, localLayoutParams.height, this);
            if (!(((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof URLDrawable)) {
              break;
            }
            localObject4 = (URLDrawable)((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.getDrawable();
            if (paramInt < 10) {
              break;
            }
            ((URLDrawable)localObject4).setAutoDownload(false);
            break;
            ((tvc)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        if (((twh)localObject4).jdField_a_of_type_Int == 2)
        {
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131695805);
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((tvc)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(2131378065, ((tvc)localObject1).jdField_a_of_type_JavaLangString);
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(2131378064, Integer.valueOf(jdField_a_of_type_Int));
          localLayoutParams = ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          this.jdField_a_of_type_Tvl.a(tyc.a(((twh)localObject4).jdField_a_of_type_JavaNetURL.toString(), 1, ((twg)localObject2).jdField_a_of_type_JavaLangString), ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView, localLayoutParams.width, localLayoutParams.height, this);
          break label1169;
        }
        ((tvc)localObject1).jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
        ((tvc)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(2131695806);
        ((tvc)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((tvc)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break label1169;
        label1799:
        if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
          break label1169;
        }
        QLog.w("SubscriptFeedsAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
        break label1169;
        label1824:
        ((tvc)localObject1).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843159);
        break label1355;
        label1838:
        if (!this.jdField_c_of_type_Boolean) {
          ((tvc)localObject1).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843158);
        }
        for (;;)
        {
          paramView.setTag(-3, Integer.valueOf((int)(this.jdField_b_of_type_Float + this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          ((tvc)localObject1).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          ((tvc)localObject1).jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          break;
          ((tvc)localObject1).jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130843160);
        }
        if (m == jdField_b_of_type_Int)
        {
          paramView.setTag(2131378059, Integer.valueOf(paramInt));
          this.j += 1;
          localObject1 = (tvd)paramView.getTag();
          m = ((tvd)localObject1).jdField_a_of_type_JavaUtilArrayList.size();
          k = 0;
          while (k < m)
          {
            localObject3 = (ViewGroup)((tvd)localObject1).jdField_a_of_type_JavaUtilArrayList.get(k);
            localObject2 = (TextView)((ViewGroup)localObject3).findViewById(2131362973);
            localObject3 = (ImageView)((ViewGroup)localObject3).findViewById(2131362972);
            if (k < this.jdField_b_of_type_JavaUtilList.size())
            {
              localObject4 = (ReadInJoyArticle)this.jdField_b_of_type_JavaUtilList.get(k);
              ((TextView)localObject2).setText(((ReadInJoyArticle)localObject4).mTitle.replaceFirst("^\\s+", ""));
              ((ImageView)localObject3).setTag(2131378064, Integer.valueOf(jdField_b_of_type_Int));
              localObject2 = (WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window");
              this.jdField_a_of_type_Tvl.a(tyc.a(((ReadInJoyArticle)localObject4).mFirstPagePicUrl, 1), (ImageView)localObject3, ((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight(), this);
            }
            k += 1;
          }
        }
        else if (m != jdField_c_of_type_Int) {}
      }
      label2150:
      localObject1 = paramView;
      break label450;
    }
  }
  
  public int getViewTypeCount()
  {
    return h;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof tvc)))
        {
          paramBitmap = (tvc)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tva
 * JD-Core Version:    0.7.0.1
 */