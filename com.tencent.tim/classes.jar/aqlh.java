import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class aqlh
  extends ReportDialog
{
  private BaseAdapter adapter = new aqli(this);
  LinearLayout bodyLayout;
  TextView countText;
  TextView desc;
  TextView dummyFirstPreviewImage;
  View framePreview;
  ImageView framePreviewImage;
  Button hu;
  LayoutInflater inflater;
  String[] items;
  ListView list;
  DialogInterface.OnClickListener onArrayItemClick;
  TextView previewImage;
  TextView rBtn;
  TextView text;
  TextView title;
  
  public aqlh(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public aqlh a(int paramInt)
  {
    this.text.setText(paramInt);
    this.text.setContentDescription(getContext().getString(paramInt));
    this.text.setVisibility(0);
    return this;
  }
  
  public aqlh a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.hu.setVisibility(8);
      return this;
    }
    this.hu.setBackgroundResource(paramInt1);
    this.hu.setContentDescription(getContext().getString(paramInt2));
    this.hu.setVisibility(0);
    this.hu.setOnClickListener(new aqlk(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public aqlh a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new aqll(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public aqlh a(String paramString)
  {
    if (paramString != null)
    {
      this.title.setText(new aofk(paramString, 5, 24));
      this.text.setContentDescription(paramString);
      this.title.setVisibility(0);
      if (this.items == null) {}
      return this;
    }
    this.title.setVisibility(8);
    return this;
  }
  
  public aqlh a(String paramString, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.text.setText(new aofk(paramString, 5, 20));
      this.text.setContentDescription(paramString);
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  public aqlh a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(new aofk(paramString, 5, 20));
    this.rBtn.setContentDescription(paramString);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new aqlj(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public aqlh b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.text.setText(paramString);
      this.text.setContentDescription(paramString);
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    return paramInt;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(2131365867));
    this.text = ((TextView)findViewById(2131365863));
    this.countText = ((TextView)findViewById(2131365841));
    this.desc = ((TextView)findViewById(2131365842));
    this.dummyFirstPreviewImage = ((TextView)findViewById(2131366154));
    this.previewImage = ((TextView)findViewById(2131373567));
    this.framePreviewImage = ((ImageView)findViewById(2131367585));
    this.framePreview = findViewById(2131367584);
    this.hu = ((Button)findViewById(2131365852));
    this.rBtn = ((TextView)findViewById(2131365858));
    this.hu.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout = ((LinearLayout)findViewById(2131363579));
    this.list = ((ListView)findViewById(2131370527));
  }
  
  protected void setSeperatorState() {}
  
  public void setTitle(int paramInt)
  {
    this.title.setText(paramInt);
    this.text.setContentDescription(getContext().getString(paramInt));
    this.title.setVisibility(0);
  }
  
  class a
    implements View.OnClickListener
  {
    int i;
    
    public a(int paramInt)
    {
      this.i = paramInt;
    }
    
    public void onClick(View paramView)
    {
      if (aqlh.this.onArrayItemClick != null)
      {
        aqlh.this.onArrayItemClick.onClick(aqlh.this, aqlh.this.customWhichToCallBack(this.i));
        aqlh.this.dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  class b
  {
    TextView text;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqlh
 * JD-Core Version:    0.7.0.1
 */