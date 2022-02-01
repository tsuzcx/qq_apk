import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class aggw
  extends agdq
{
  private BaseFileAssistantActivity b;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  private HashMap<Integer, ArrayList<aggw.a>> kH = new HashMap();
  private Context mContext;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private View.OnClickListener r;
  
  public aggw(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.q = paramOnClickListener1;
    this.r = paramOnClickListener2;
    this.g = paramOnLongClickListener;
    this.eV = paramOnClickListener3;
    this.mContext = paramContext;
    this.b = paramBaseFileAssistantActivity;
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, aggw.b paramb)
  {
    boolean bool;
    switch (paramFileManagerEntity.status)
    {
    case 17: 
    default: 
      paramb.c.setVisibility(4);
      return;
    case 2: 
    case 18: 
      paramb.c.setVisibility(0);
      paramb.c.setState(1);
      paramb.actionType = 2;
      return;
    case 3: 
      bool = ahbj.isFileExists(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.bSend) && (bool)) {
        paramb.c.setState(3);
      }
      for (;;)
      {
        paramb.c.setVisibility(0);
        paramb.actionType = 3;
        return;
        paramb.c.setState(2);
      }
    case 1: 
      bool = ahbj.isFileExists(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5) || (bool))
      {
        paramb.c.setVisibility(4);
        return;
      }
      paramb.c.setVisibility(0);
      paramb.c.setState(2);
      paramb.actionType = 1;
      return;
    case 0: 
      paramb.c.setVisibility(0);
      paramb.actionType = 3;
      bool = ahbj.isFileExists(paramFileManagerEntity.getFilePath());
      if ((paramFileManagerEntity.bSend) && (bool))
      {
        paramb.c.setState(3);
        return;
      }
      paramb.c.setState(2);
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      paramb.c.setVisibility(4);
      return;
    case 4: 
      paramb.actionType = 1;
      paramb.c.setVisibility(0);
      paramb.c.setState(2);
      return;
    case 9: 
    case 12: 
      paramb.c.setVisibility(4);
      return;
    case 10: 
    case 11: 
      paramb.c.setVisibility(4);
      return;
    case 13: 
      paramb.c.setVisibility(0);
      paramb.c.setState(2);
      paramb.actionType = 1;
      return;
    case 14: 
    case 15: 
      paramb.c.setVisibility(4);
      return;
    case -1: 
      paramb.c.setVisibility(0);
      paramb.actionType = 1;
      paramb.c.setState(2);
      return;
    }
    paramb.c.setVisibility(4);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (this.b.akL())
    {
      localObject3 = (ArrayList)this.kH.get(Integer.valueOf(paramInt1));
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (aggw.a)((Iterator)localObject3).next();
          if (((aggw.a)localObject2).srcPos != paramInt2) {
            break label951;
          }
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((aggw.a)localObject2).cWU);
        }
      }
    }
    label951:
    for (;;)
    {
      break;
      for (localObject1 = localObject2; localObject1 == null; localObject1 = (FileManagerEntity)getChild(paramInt1, paramInt2)) {
        return paramView;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          localObject2 = new aggw.b();
          paramViewGroup = this.mInflater.inflate(2131561003, paramViewGroup, false);
          paramView = paramViewGroup;
          paramViewGroup = paramView;
        }
        catch (Exception paramViewGroup)
        {
          continue;
        }
        try
        {
          ((aggw.b)localObject2).layout = ((RelativeLayout)paramView.findViewById(2131376838));
          paramViewGroup = paramView;
          ((aggw.b)localObject2).layout.setOnLongClickListener(this.g);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).layout.setTag(localObject2);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).mask = paramView.findViewById(2131371161);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).c = ((CircleFileStateView)paramView.findViewById(2131361963));
          paramViewGroup = paramView;
          ((aggw.b)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131367036));
          paramViewGroup = paramView;
          ((aggw.b)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367020));
          paramViewGroup = paramView;
          ((aggw.b)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).fileName = ((TextView)paramView.findViewById(2131367034));
          paramViewGroup = paramView;
          ((aggw.b)localObject2).fileName.setGravity(48);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).fileName.setMaxLines(2);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).aY = ((TextView)paramView.findViewById(2131367018));
          paramViewGroup = paramView;
          ((aggw.b)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
          paramViewGroup = paramView;
          paramView.setTag(localObject2);
          paramViewGroup = paramView;
          ahav.a(((aggw.b)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject1);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).ccW = paramInt1;
          paramViewGroup = paramView;
          ((aggw.b)localObject2).cWL = paramInt2;
          paramViewGroup = paramView;
          ((aggw.b)localObject2).layout.setVisibility(0);
          paramViewGroup = paramView;
          if (!ahav.a(this.mContext, (FileManagerEntity)localObject1)) {
            continue;
          }
          paramViewGroup = paramView;
          ((aggw.b)localObject2).mask.setVisibility(0);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).layout.setOnClickListener(null);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).entity = localObject1;
          paramViewGroup = paramView;
          ((aggw.b)localObject2).c.setOnClickListener(this.eV);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).c.setTag(localObject2);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).c.setProgressRingWidth(3.0F);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).fileName.setText(((FileManagerEntity)localObject1).fileName);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).c.setProgress((int)(((FileManagerEntity)localObject1).fProgress * 100.0F));
          paramViewGroup = paramView;
          if (5 != ((FileManagerEntity)localObject1).cloudType)
          {
            paramViewGroup = paramView;
            ahav.I((FileManagerEntity)localObject1);
          }
          paramViewGroup = paramView;
          ((aggw.b)localObject2).c.setEnabled(true);
          paramViewGroup = paramView;
          a((FileManagerEntity)localObject1, (aggw.b)localObject2);
          paramViewGroup = paramView;
          if (!this.b.akL()) {
            continue;
          }
          paramViewGroup = paramView;
          ((aggw.b)localObject2).c.setVisibility(8);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramViewGroup = paramView;
          ((aggw.b)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(agmz.b((FileManagerEntity)localObject1));
        }
        catch (Exception localException)
        {
          paramView = paramViewGroup;
          paramViewGroup = localException;
          paramViewGroup.printStackTrace();
          continue;
          paramViewGroup = paramView;
          ((aggw.b)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          continue;
        }
        paramViewGroup = paramView;
        if (((FileManagerEntity)localObject1).nFileType == 13)
        {
          paramViewGroup = paramView;
          ((aggw.b)localObject2).c.setVisibility(8);
        }
        paramViewGroup = paramView;
        localObject3 = (LinearLayout.LayoutParams)((aggw.b)localObject2).aY.getLayoutParams();
        paramViewGroup = paramView;
        ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(3.0F, this.mContext.getResources());
        paramViewGroup = paramView;
        ((aggw.b)localObject2).aY.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.mContext.getResources().getDisplayMetrics()), 1.0F);
        paramViewGroup = paramView;
        ((aggw.b)localObject2).aY.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramViewGroup = paramView;
        ((aggw.b)localObject2).fileName.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.mContext.getResources().getDisplayMetrics()), 1.0F);
        paramViewGroup = paramView;
        ahav.b(((aggw.b)localObject2).aY, (FileManagerEntity)localObject1);
        return paramView;
        localObject2 = (aggw.b)paramView.getTag();
        continue;
        paramViewGroup = paramView;
        ((aggw.b)localObject2).mask.setVisibility(8);
        paramViewGroup = paramView;
        ((aggw.b)localObject2).layout.setOnClickListener(this.r);
        paramViewGroup = paramView;
        ((aggw.b)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.r);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject1 = aa(paramInt);
    if (localObject1 != null)
    {
      if (!this.kH.containsKey(Integer.valueOf(paramInt))) {
        this.kH.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      if (this.b.akL())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        int j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (FileManagerEntity)localIterator.next();
          int k;
          if ((((FileManagerEntity)localObject2).getCloudType() == 0) || ((((FileManagerEntity)localObject2).getCloudType() == 5) && (!((FileManagerEntity)localObject2).bSend) && (((FileManagerEntity)localObject2).status != 1)))
          {
            k = j + 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            k = j;
            j = i;
            i = k;
            break;
            if (((FileManagerEntity)localObject2).sendCloudUnsuccessful())
            {
              k = j + 1;
              j = i;
              i = k;
            }
            else
            {
              localObject2 = new aggw.a();
              ((aggw.a)localObject2).srcPos = i;
              ((aggw.a)localObject2).cWU = (i + j);
              localArrayList.add(localObject2);
              k = i + 1;
              i = j;
              j = k;
            }
          }
        }
        this.kH.put(Integer.valueOf(paramInt), localArrayList);
        i = ((ArrayList)localObject1).size() - j;
      }
    }
    else
    {
      return i;
    }
    this.kH.clear();
    return ((ArrayList)localObject1).size();
  }
  
  class a
  {
    int cWU;
    int srcPos;
    
    a() {}
  }
  
  public class b
    implements Cloneable
  {
    public CheckBox a;
    public AsyncImageView a;
    public TextView aY;
    public int actionType;
    public CircleFileStateView c;
    public int cWL;
    public int ccW;
    public Object entity;
    public TextView fileName;
    public RelativeLayout layout;
    public View mask;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggw
 * JD-Core Version:    0.7.0.1
 */