import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class atse
  extends atpo
{
  private BaseFileAssistantActivity b;
  private View.OnClickListener eV;
  private View.OnLongClickListener g;
  private HashMap<Integer, ArrayList<atse.a>> kH = new HashMap();
  private Context mContext;
  private LayoutInflater mInflater;
  private View.OnClickListener q;
  private View.OnClickListener r;
  
  public atse(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
  
  private String aW(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  private String f(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject;
    String str2;
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      localObject = null;
      String str3 = this.b.getString(2131693588);
      str2 = aueh.g(paramFileManagerEntity.fileSize) + aW(str3, (String)localObject) + aW(str3, str1);
      localObject = aueh.g(paramFileManagerEntity.fileSize) + aW(str3, str1);
      if ((paramFileManagerEntity.getCloudType() == 2) && (3 == paramFileManagerEntity.nOpType)) {
        localObject = str2;
      }
      break;
    }
    do
    {
      return localObject;
      localObject = this.b.getString(2131693540);
      str1 = audx.b(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType, false);
      str1 = str1 + this.b.getString(2131693543);
      break;
      localObject = this.b.getString(2131693614);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
      localObject = this.b.getString(2131700496);
      break;
      if (paramFileManagerEntity.getCloudType() == 5) {
        return str2;
      }
    } while (paramFileManagerEntity.TroopUin == 0L);
    return str2;
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
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (atse.a)((Iterator)localObject3).next();
          if (((atse.a)localObject2).srcPos != paramInt2) {
            break label1537;
          }
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((atse.a)localObject2).cWU);
        }
      }
    }
    while (localObject2 == null)
    {
      return paramView;
      localObject2 = (FileManagerEntity)getChild(paramInt1, paramInt2);
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject3 = new atse.b();
        localObject1 = paramView;
        paramView = this.mInflater.inflate(2131561003, paramViewGroup, false);
        localObject1 = paramView;
        ((atse.b)localObject3).layout = ((RelativeLayout)paramView.findViewById(2131376838));
        localObject1 = paramView;
        ((atse.b)localObject3).mask = paramView.findViewById(2131371161);
        localObject1 = paramView;
        ((atse.b)localObject3).layout.setOnLongClickListener(this.g);
        localObject1 = paramView;
        ((atse.b)localObject3).layout.setTag(localObject3);
        localObject1 = paramView;
        if (audx.a(this.mContext, (FileManagerEntity)localObject2))
        {
          localObject1 = paramView;
          ((atse.b)localObject3).mask.setVisibility(0);
          localObject1 = paramView;
          ((atse.b)localObject3).layout.setOnClickListener(null);
          localObject1 = paramView;
          ((atse.b)localObject3).el = ((Button)paramView.findViewById(2131361963));
          localObject1 = paramView;
          ((atse.b)localObject3).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131367036));
          localObject1 = paramView;
          ((atse.b)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367020));
          localObject1 = paramView;
          ((atse.b)localObject3).J = ((ImageView)paramView.findViewById(2131367042));
          localObject1 = paramView;
          ((atse.b)localObject3).fileName = ((TextView)paramView.findViewById(2131367034));
          localObject1 = paramView;
          ((atse.b)localObject3).k = ((ProgressBar)paramView.findViewById(2131367035));
          localObject1 = paramView;
          ((atse.b)localObject3).aY = ((TextView)paramView.findViewById(2131367018));
          localObject1 = paramView;
          ((atse.b)localObject3).time = ((TextView)paramView.findViewById(2131370129));
          localObject1 = paramView;
          ((atse.b)localObject3).delBtn = ((Button)paramView.findViewById(2131365671));
          localObject1 = paramView;
          ((atse.b)localObject3).delBtn.setOnClickListener(this.q);
          localObject1 = paramView;
          ((atse.b)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(wja.dp2px(70.0F, this.mContext.getResources()), wja.dp2px(70.0F, this.mContext.getResources()));
          localObject1 = paramView;
          paramView.setTag(localObject3);
          paramViewGroup = (ViewGroup)localObject3;
        }
      }
      catch (Exception paramView)
      {
        paramViewGroup = paramView;
        paramView = (View)localObject1;
      }
      try
      {
        audx.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, (FileManagerEntity)localObject2);
        paramViewGroup.ccW = paramInt1;
        paramViewGroup.cWL = paramInt2;
        paramViewGroup.layout.setVisibility(0);
        paramViewGroup.entity = localObject2;
        paramViewGroup.el.setOnClickListener(this.eV);
        paramViewGroup.el.setTag(paramViewGroup);
        paramViewGroup.fileName.setText(audx.kY(((FileManagerEntity)localObject2).fileName));
        paramViewGroup.aY.setText(f((FileManagerEntity)localObject2));
        paramViewGroup.time.setVisibility(0);
        paramViewGroup.time.setText(audx.a((FileManagerEntity)localObject2));
        paramViewGroup.J.setVisibility(8);
        if (5 != ((FileManagerEntity)localObject2).cloudType) {
          audx.I((FileManagerEntity)localObject2);
        }
        paramViewGroup.el.setEnabled(true);
        switch (((FileManagerEntity)localObject2).status)
        {
        case 17: 
          paramViewGroup.el.setVisibility(8);
          paramViewGroup.k.setVisibility(8);
          if (!this.b.akL()) {
            break label1524;
          }
          paramViewGroup.el.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramViewGroup.k.setVisibility(8);
          paramViewGroup.time.setVisibility(0);
          paramViewGroup.layout.setBackgroundResource(2130839639);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(atwb.b((FileManagerEntity)localObject2));
          return paramView;
        }
      }
      catch (Exception paramViewGroup)
      {
        break label900;
      }
      localObject1 = paramView;
      ((atse.b)localObject3).mask.setVisibility(8);
      localObject1 = paramView;
      ((atse.b)localObject3).layout.setOnClickListener(this.r);
      continue;
      label900:
      paramViewGroup.printStackTrace();
      continue;
      localObject1 = paramView;
      paramViewGroup = (atse.b)paramView.getTag();
      continue;
      paramViewGroup.el.setText(2131693840);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.actionType = 2;
      paramViewGroup.time.setVisibility(4);
      paramViewGroup.k.setVisibility(0);
      paramViewGroup.k.setProgress((int)(((FileManagerEntity)localObject2).getfProgress() * 100.0F));
      continue;
      paramViewGroup.el.setText(2131693841);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.actionType = 3;
      paramViewGroup.time.setVisibility(4);
      paramViewGroup.k.setVisibility(0);
      continue;
      paramBoolean = aueh.isFileExists(((FileManagerEntity)localObject2).getFilePath());
      if ((((FileManagerEntity)localObject2).getCloudType() == 3) || (((FileManagerEntity)localObject2).getCloudType() == 5) || (paramBoolean))
      {
        paramViewGroup.el.setText(2131693842);
        paramViewGroup.el.setVisibility(0);
      }
      for (paramViewGroup.actionType = 0;; paramViewGroup.actionType = 1)
      {
        paramViewGroup.k.setVisibility(4);
        break;
        paramViewGroup.el.setText(2131693838);
        paramViewGroup.el.setVisibility(0);
      }
      paramViewGroup.el.setText(2131693841);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.actionType = 3;
      paramViewGroup.time.setVisibility(4);
      paramViewGroup.k.setVisibility(0);
      continue;
      paramViewGroup.k.setVisibility(4);
      paramViewGroup.el.setText(2131693842);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.actionType = 0;
      continue;
      paramViewGroup.k.setVisibility(4);
      paramViewGroup.el.setText(2131693838);
      paramViewGroup.actionType = 1;
      paramViewGroup.el.setVisibility(0);
      continue;
      paramViewGroup.k.setVisibility(4);
      paramViewGroup.k.setVisibility(4);
      paramViewGroup.el.setText(2131693842);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.actionType = 0;
      continue;
      paramViewGroup.k.setVisibility(4);
      paramViewGroup.el.setText(2131693842);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.actionType = 0;
      continue;
      paramViewGroup.k.setVisibility(8);
      paramViewGroup.el.setText(2131693838);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.actionType = 1;
      continue;
      paramViewGroup.el.setText(2131693842);
      paramViewGroup.el.setVisibility(8);
      paramViewGroup.actionType = 2;
      paramViewGroup.k.setVisibility(0);
      paramViewGroup.k.setProgress((int)(((FileManagerEntity)localObject2).getfProgress() * 100.0F));
      continue;
      paramViewGroup.el.setText(2131693838);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.actionType = 1;
      paramViewGroup.k.setVisibility(4);
      continue;
      paramViewGroup.k.setVisibility(4);
      paramViewGroup.el.setText(2131693839);
      paramViewGroup.el.setVisibility(0);
      paramViewGroup.el.setEnabled(false);
      paramViewGroup.actionType = 0;
      continue;
      label1524:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      continue;
      label1537:
      break;
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
              localObject2 = new atse.a();
              ((atse.a)localObject2).srcPos = i;
              ((atse.a)localObject2).cWU = (i + j);
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
    public ImageView J;
    public CheckBox a;
    public AsyncImageView a;
    public TextView aY;
    public int actionType;
    public int cWL;
    public int ccW;
    public Button delBtn;
    public Button el;
    public Object entity;
    public TextView fileName;
    public ProgressBar k;
    public RelativeLayout layout;
    public View mask;
    public TextView time;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atse
 * JD-Core Version:    0.7.0.1
 */