import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.widget.FixSizeImageView;
import java.util.ArrayList;
import java.util.List;

public class atkj
  extends atjr
{
  public atkj(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131558964, null);
      paramViewGroup = new atkj.a(null);
      paramViewGroup.g = ((AsyncImageView)paramView.findViewById(2131364710));
      paramViewGroup.aeL = ((TextView)paramView.findViewById(2131364718));
      paramViewGroup.aeM = ((TextView)paramView.findViewById(2131364717));
      paramViewGroup.aeO = ((TextView)paramView.findViewById(2131364716));
      paramViewGroup.ab = ((CheckBox)paramView.findViewById(2131369420));
      paramViewGroup.aeQ = ((TextView)paramView.findViewById(2131364709));
      paramViewGroup.j = ((FixSizeImageView)paramView.findViewById(2131364708));
      paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131364719));
      paramViewGroup.Kw = paramView.findViewById(2131367356);
      paramViewGroup.g.setAsyncClipSize(wja.dp2px(36.0F, this.context.getResources()), wja.dp2px(36.0F, this.context.getResources()));
      paramView.setTag(paramViewGroup);
      if (!paramBoolean1) {
        break label343;
      }
      paramViewGroup.ab.setVisibility(0);
      paramViewGroup.ab.setChecked(paramBoolean2);
    }
    for (;;)
    {
      paramOnLongClickListener = (FileManagerEntity)paramatiu;
      athu.d(paramViewGroup.g, paramOnLongClickListener);
      paramViewGroup.a = paramatiu;
      paramViewGroup.isSelected = paramBoolean2;
      paramViewGroup.checkBox = ((CheckBox)paramView.findViewById(2131369420));
      paramView.setOnClickListener(paramOnClickListener);
      paramatiu = paramOnLongClickListener.fileName;
      paramViewGroup.aeL.setText(paramatiu);
      paramViewGroup.aeM.setText(auqb.bG(paramOnLongClickListener.lastTime) + " 微云文件 ");
      paramViewGroup.aeO.setText(athu.c((float)paramOnLongClickListener.fileSize));
      return paramView;
      paramViewGroup = (atkj.a)paramView.getTag();
      break;
      label343:
      paramViewGroup.ab.setVisibility(8);
    }
  }
  
  public List<atiw> a(atiu paramatiu)
  {
    paramatiu = new ArrayList();
    paramatiu.add(d);
    paramatiu.add(b);
    return paramatiu;
  }
  
  public void destroy() {}
  
  public List<atiw> gt()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(d);
    localArrayList.add(c);
    localArrayList.add(b);
    return localArrayList;
  }
  
  class a
    extends atjv.a
  {
    View Kw;
    CheckBox ab;
    TextView aeL;
    TextView aeM;
    TextView aeO;
    TextView aeQ;
    AsyncImageView g;
    FixSizeImageView j;
    ProgressBar progressBar;
    
    private a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkj
 * JD-Core Version:    0.7.0.1
 */