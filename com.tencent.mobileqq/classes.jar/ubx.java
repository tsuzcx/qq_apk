import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ubx
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private static int e;
  private float jdField_a_of_type_Float;
  private aklg jdField_a_of_type_Aklg;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<ucy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private List<Object> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private List<ubz> jdField_c_of_type_JavaUtilList = new ArrayList();
  private float d;
  private int f;
  
  static
  {
    jdField_b_of_type_Int = 1;
    e = 3;
    jdField_d_of_type_Int = 1;
  }
  
  public ubx(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_Aklg = new aklg(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297987);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297989);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297988);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297986);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    b();
  }
  
  private void a(uby paramuby, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramuby.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Aklg.a(1008, paramString));
      return;
    }
    paramuby.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.isEmpty())
    {
      bcef.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.jdField_a_of_type_JavaUtilHashSet.size(), 0, "", "", "", "");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
        }
        String str = (String)localIterator.next();
        Object localObject1 = "";
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("folder_status", pay.jdField_d_of_type_Int);
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        odq.a(null, str, "0X80081C7", "0X80081C7", 0, 0, "", "", "", (String)localObject1, false);
      }
    }
    label128:
    if (this.f > 0) {
      bcef.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.f, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Boolean) {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_JavaUtilHashSet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_Aklg.a();
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList = null;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List<ucy> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    ArrayList localArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList.addAll(localArrayList);
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_c_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = e;
    Object localObject = this.jdField_b_of_type_JavaUtilList.get(paramInt);
    if ((localObject instanceof ucy)) {
      paramInt = jdField_a_of_type_Int;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (!(localObject instanceof ubz));
    return jdField_b_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilList.size()))
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    int j = getItemViewType(paramInt);
    Object localObject2 = null;
    int i;
    if (paramView == null) {
      if (j == jdField_a_of_type_Int)
      {
        localObject2 = new uby(this);
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560384, null);
        ((uby)localObject2).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject1).findViewById(2131377980));
        ((uby)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131377994));
        ((uby)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131377999));
        ((uby)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131376255));
        ((uby)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131380163));
        ((uby)localObject2).c = ((TextView)((View)localObject1).findViewById(2131366521));
        ((uby)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131370732));
        ((uby)localObject2).jdField_b_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131370712));
        ((uby)localObject2).jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((uby)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, (View)localObject1);
        ((uby)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((uby)localObject2).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((uby)localObject2).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView = ((uby)localObject2).c;
        if (this.jdField_a_of_type_Boolean)
        {
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166079);
          label294:
          paramView.setTextColor(i);
          paramView = ((uby)localObject2).jdField_a_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Boolean) {
            break label413;
          }
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166085);
          label325:
          paramView.setTextColor(i);
          paramView = ((uby)localObject2).jdField_b_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Boolean) {
            break label428;
          }
          i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166088);
          label356:
          paramView.setTextColor(i);
          label362:
          paramView = (View)localObject1;
          if (localObject1 != null)
          {
            paramView = (View)localObject1;
            if (localObject2 != null)
            {
              ((View)localObject1).setTag(localObject2);
              paramView = (View)localObject1;
            }
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
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166084);
        break label294;
        label413:
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166078);
        break label325;
        label428:
        i = this.jdField_a_of_type_AndroidContentResResources.getColor(2131166087);
        break label356;
        if (j != jdField_b_of_type_Int) {
          break label1261;
        }
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559994, null);
        break label362;
      }
      if (j == jdField_a_of_type_Int)
      {
        paramView.setTag(2131377986, Integer.valueOf(paramInt));
        localObject2 = (uby)paramView.getTag();
        localucy = (ucy)getItem(paramInt);
        if (this.jdField_a_of_type_JavaUtilHashSet != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localucy.jdField_a_of_type_JavaLangString);
        }
        ((uby)localObject2).jdField_a_of_type_JavaLangString = localucy.jdField_a_of_type_JavaLangString;
        a((uby)localObject2, localucy.jdField_a_of_type_JavaLangString);
        localObject1 = uda.a().a(localucy.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = uda.a().a(localucy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ((uby)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            ((uby)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(TimeManager.getInstance().getMsgDisplayTime(localucy.jdField_a_of_type_JavaLangString, localucy.jdField_a_of_type_Long));
            if (localucy.jdField_b_of_type_Int <= 0) {
              break label922;
            }
            i = 3;
            bjpg.a(((uby)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, localucy.jdField_b_of_type_Int, 2130850325, 99, null);
            if (localucy.jdField_a_of_type_JavaUtilList.size() <= 0) {
              break label1025;
            }
            localucz = (ucz)localucy.jdField_a_of_type_JavaUtilList.get(0);
            if (localucz.jdField_a_of_type_Int != 0) {
              break label928;
            }
            ((uby)localObject2).c.setMaxLines(1);
            ((uby)localObject2).c.setText(new QQText(localucz.c.replaceFirst("^\\s+", ""), 3, 20));
            ((uby)localObject2).jdField_a_of_type_AndroidViewViewGroup.setTag(2131377983, Integer.valueOf(localucy.jdField_b_of_type_Int));
            ((uby)localObject2).jdField_a_of_type_AndroidViewViewGroup.setTag(2131377992, localucy.jdField_a_of_type_JavaLangString);
            ((uby)localObject2).jdField_a_of_type_AndroidViewViewGroup.setTag(2131377985, localObject1);
            ((uby)localObject2).jdField_a_of_type_AndroidViewViewGroup.setTag(2131377984, Integer.valueOf(jdField_c_of_type_Int));
            ((uby)localObject2).jdField_a_of_type_AndroidViewViewGroup.setTag(localucy);
            ((uby)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377983, localucy);
            ((uby)localObject2).jdField_a_of_type_AndroidWidgetButton.setTag(2131377992, localucy.jdField_a_of_type_JavaLangString);
            ((uby)localObject2).jdField_a_of_type_AndroidWidgetButton.setTag(2131377985, localObject1);
            ((uby)localObject2).jdField_b_of_type_AndroidWidgetButton.setTag(2131377992, localucy.jdField_a_of_type_JavaLangString);
            paramView.setTag(-3, Integer.valueOf((int)(this.jdField_c_of_type_Float + this.jdField_d_of_type_Float)));
          }
        }
      }
      label922:
      label928:
      while (j != jdField_b_of_type_Int) {
        for (;;)
        {
          ucy localucy;
          ucz localucz;
          localObject1 = paramView;
          break;
          ((uby)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localucy.jdField_a_of_type_JavaLangString);
          continue;
          ((uby)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          continue;
          i = 0;
          continue;
          if (localucz.jdField_a_of_type_Int == 1)
          {
            ((uby)localObject2).c.setMaxLines(2);
            ((uby)localObject2).c.setText(localucz.jdField_b_of_type_JavaLangString.replaceFirst("^\\s+", ""));
          }
          else if (localucz.jdField_a_of_type_Int == 2)
          {
            ((uby)localObject2).c.setMaxLines(1);
            ((uby)localObject2).c.setText(2131695988);
          }
          else
          {
            ((uby)localObject2).c.setMaxLines(1);
            ((uby)localObject2).c.setText(2131695989);
            continue;
            if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
              QLog.w("SubscriptFeedsNewAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
            }
          }
        }
      }
      label1025:
      localObject1 = (ubz)getItem(paramInt);
      ((TextView)paramView.findViewById(2131371416)).setText(((ubz)localObject1).jdField_a_of_type_JavaLangString);
      ((ImageView)paramView.findViewById(2131371415)).setImageDrawable(((ubz)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localObject2 = (DragTextView)paramView.findViewById(2131380163);
      ((DragTextView)localObject2).setDragViewType(0, paramView);
      if (((ubz)localObject1).jdField_a_of_type_Int > 0) {}
      for (i = 3;; i = 0)
      {
        bjpg.a((TextView)localObject2, i, ((ubz)localObject1).jdField_a_of_type_Int, 2130850325, 99, null);
        if (((ubz)localObject1).jdField_a_of_type_Int > 0) {
          paramView.findViewById(2131362983).setVisibility(8);
        }
        localObject2 = (ViewGroup)paramView.findViewById(2131371414);
        ((ViewGroup)localObject2).setTag(2131377984, Integer.valueOf(jdField_d_of_type_Int));
        ((ViewGroup)localObject2).setTag(2131378207, ((ubz)localObject1).jdField_b_of_type_JavaLangString);
        ((ViewGroup)localObject2).setTag(2131375876, Integer.valueOf(((ubz)localObject1).jdField_b_of_type_Int));
        ((ViewGroup)localObject2).setTag(2131375877, Integer.valueOf(((ubz)localObject1).jdField_a_of_type_Int));
        ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break;
      }
      label1261:
      localObject1 = paramView;
      break label362;
    }
  }
  
  public int getViewTypeCount()
  {
    return e;
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
        if ((paramBitmap != null) && ((paramBitmap instanceof uby)))
        {
          paramBitmap = (uby)paramBitmap;
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
 * Qualified Name:     ubx
 * JD-Core Version:    0.7.0.1
 */