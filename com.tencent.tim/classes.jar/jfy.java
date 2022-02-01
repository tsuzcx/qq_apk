import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class jfy
  extends BaseAdapter
{
  private final Context mContext;
  private final LayoutInflater mInflater;
  private List<jgf> mObjects = new ArrayList();
  private int mTextSize;
  private int screenWidth;
  
  public jfy(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.screenWidth = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.mTextSize = wja.dp2px(14.0F, this.mContext.getResources());
  }
  
  private BitmapDrawable a(String paramString)
  {
    Object localObject = null;
    if (0 == 0)
    {
      localObject = VideoController.a().b();
      if ((((iiv)localObject).amI != 1) && (((iiv)localObject).amI != 2)) {
        break label71;
      }
    }
    label71:
    for (int i = 1; i != 0; i = 0)
    {
      localObject = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new BitmapDrawable(this.mContext.getResources(), ((VideoAppInterface)localObject).a(0, paramString, null, true, true));
      return localObject;
    }
    paramString = VideoController.a().a(String.valueOf(paramString), String.valueOf(((iiv)localObject).ll), ((iiv)localObject).relationType, true, true);
    return new BitmapDrawable(this.mContext.getResources(), paramString);
  }
  
  private View a(LayoutInflater paramLayoutInflater, int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = paramLayoutInflater.inflate(paramInt2, paramViewGroup, false);
    }
    paramLayoutInflater = a(paramInt1);
    paramView = localView.findViewById(2131368375);
    paramViewGroup = (TextView)localView.findViewById(2131379401);
    paramView.setVisibility(0);
    paramView.setBackgroundDrawable(a(paramLayoutInflater.hm()));
    paramViewGroup.setPadding(wja.dp2px(10.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()), wja.dp2px(10.0F, this.mContext.getResources()), wja.dp2px(8.0F, this.mContext.getResources()));
    paramViewGroup.setText(paramLayoutInflater.getContent());
    paramViewGroup.setTextColor(-1);
    paramViewGroup.setSpannableFactory(aofk.a);
    return localView;
  }
  
  public jgf a(int paramInt)
  {
    return (jgf)this.mObjects.get(paramInt);
  }
  
  public void a(jgf paramjgf)
  {
    this.mObjects.add(paramjgf);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.mObjects.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = a(this.mInflater, paramInt, paramView, paramViewGroup, 2131559973);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void k(List<jgf> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      jgf.bz(this.mObjects);
    }
    this.mObjects.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfy
 * JD-Core Version:    0.7.0.1
 */