import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class otz
{
  static boolean ayl;
  private static Context mContext;
  private static int mScreenHeight;
  private static int mScreenWidth;
  static ArrayList<oub.d> ml = new ArrayList();
  protected AdapterView.c d = new oua(this);
  private Activity mActivity;
  
  public otz(Activity paramActivity, ArrayList<oub.d> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    mContext = paramActivity.getApplicationContext();
    mScreenHeight = paramInt1;
    mScreenWidth = paramInt2;
    ayl = paramBoolean;
    ml = W(paramArrayList);
  }
  
  private ArrayList<oub.d> W(ArrayList<oub.d> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramArrayList.size() <= 6)
    {
      localArrayList.addAll(paramArrayList);
      return localArrayList;
    }
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= 6) {
        break;
      }
      localArrayList.add(paramArrayList.get(i));
      i += 1;
    }
  }
  
  @TargetApi(9)
  private void o(RelativeLayout paramRelativeLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "buildView!");
    }
    int i = wja.dp2px(2.0F, mContext.getResources());
    int j = (mScreenWidth - i) / 2;
    paramRelativeLayout = (GridView)paramRelativeLayout.findViewById(2131376916);
    paramRelativeLayout.setColumnWidth(j);
    paramRelativeLayout.setStretchMode(0);
    paramRelativeLayout.setHorizontalSpacing(i);
    paramRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, rU()));
    paramRelativeLayout.setNumColumns(2);
    paramRelativeLayout.setOnItemClickListener(this.d);
    if (Build.VERSION.SDK_INT >= 9) {
      paramRelativeLayout.setOverScrollMode(2);
    }
    paramRelativeLayout.setAdapter(new otz.a());
  }
  
  static int rU()
  {
    if (ml == null) {
      return 0;
    }
    int i = ml.size();
    int j = (mScreenHeight - wja.dp2px(110.0F, mContext.getResources())) / 3;
    if (i % 2 == 0) {
      return i / 2 * j;
    }
    return (i + 1) / 2 * j;
  }
  
  public View a(Activity paramActivity, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramView = (RelativeLayout)paramView;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof otz.b)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView reuse!");
        }
        return paramView;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView new create!");
    }
    paramActivity = (RelativeLayout)LayoutInflater.from(paramActivity).inflate(2131559797, paramViewGroup, false);
    paramView = paramActivity.getLayoutParams();
    paramView.height = mScreenHeight;
    paramActivity.setLayoutParams(paramView);
    paramView = new otz.b();
    paramView.f = ((GridView)paramActivity.findViewById(2131376916));
    paramView.b = ((VideoFeedsAlphaMaskView)paramActivity.findViewById(2131371173));
    paramView.vJ = ((TextView)paramActivity.findViewById(2131376902));
    paramActivity.setTag(paramView);
    if ((ml == null) && (ayl))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "createView getRecommendInfo error");
      }
      paramView.f.setVisibility(8);
      paramView.vJ.setVisibility(0);
      paramViewGroup = paramView.b.getLayoutParams();
      int i = wja.dp2px(66.0F, mContext.getResources());
      paramViewGroup.height = (mScreenHeight - i);
      paramView.b.setLayoutParams(paramViewGroup);
    }
    for (;;)
    {
      return paramActivity;
      paramViewGroup = paramView.b.getLayoutParams();
      paramViewGroup.height = rU();
      paramView.b.setLayoutParams(paramViewGroup);
      paramView.f.setVisibility(0);
      paramView.vJ.setVisibility(8);
      o(paramActivity);
    }
  }
  
  public void cg(ArrayList<oub.d> paramArrayList)
  {
    ml = W(paramArrayList);
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public oub.d a(int paramInt)
    {
      if (otz.ml != null) {
        return (oub.d)otz.ml.get(paramInt);
      }
      return null;
    }
    
    public int getCount()
    {
      if (otz.ml != null) {
        return otz.ml.size();
      }
      return 0;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject1;
      Object localObject2;
      int i;
      if (paramView == null)
      {
        localView = LayoutInflater.from(otz.l()).inflate(2131559796, paramViewGroup, false);
        paramView = new otz.a.a();
        localObject1 = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((otz.mScreenHeight - wja.dp2px(110.0F, otz.l().getResources())) / 3);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of item is" + ((ViewGroup.LayoutParams)localObject1).height);
        }
        paramView.e = ((URLImageView)localView.findViewById(2131376918));
        localObject2 = paramView.e.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((otz.mScreenWidth - wja.dp2px(2.0F, otz.l().getResources())) / 2);
        ((ViewGroup.LayoutParams)localObject2).height = (((ViewGroup.LayoutParams)localObject2).width * 9 / 16);
        paramView.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of image is" + ((ViewGroup.LayoutParams)localObject2).height);
        }
        paramView.text = ((TextView)localView.findViewById(2131376934));
        if (((ViewGroup.LayoutParams)localObject1).height - ((ViewGroup.LayoutParams)localObject2).height - wja.dp2px(40.0F, otz.l().getResources()) > wja.dp2px(16.0F, otz.l().getResources()))
        {
          i = 2;
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, " number is" + i);
          }
          if ((Build.MANUFACTURER.toLowerCase().contains("meizu")) && (Build.VERSION.SDK_INT <= 16))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "this is meizu");
            }
            localObject1 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject1).setMargins(12, 0, 12, 1);
            paramView.text.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramView.text.setTextSize(1, 10.0F);
          }
          paramView.text.setMaxLines(i);
          localView.setTag(paramView);
        }
      }
      for (;;)
      {
        localObject1 = a(paramInt);
        if (localObject1 != null)
        {
          localObject2 = ((oub.d)localObject1).url;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
          localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
          localURLDrawableOptions.mFailedDrawable = localColorDrawable;
          localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
          if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
            ((URLDrawable)localObject2).restartDownload();
          }
          paramView.e.setImageDrawable((Drawable)localObject2);
          paramView.text.setText(((oub.d)localObject1).title);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "recommendInfo position = " + paramInt + "; url =" + localObject2 + "; title = " + ((oub.d)localObject1).title);
          }
        }
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        i = 1;
        break;
        localObject1 = (otz.a.a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject1;
      }
    }
    
    class a
    {
      URLImageView e;
      TextView text;
      
      a() {}
    }
  }
  
  public static class b
  {
    public VideoFeedsAlphaMaskView b;
    GridView f;
    TextView vJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otz
 * JD-Core Version:    0.7.0.1
 */