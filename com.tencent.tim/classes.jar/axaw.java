import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.model.WMLogic;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter.7;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axaw
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements DatePicker.OnDateChangedListener
{
  private List<WMEditItem> Mk;
  private axaw.b jdField_a_of_type_Axaw$b;
  private WMEditItem jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem;
  private EditText bL;
  private Activity mContext;
  
  public axaw(Activity paramActivity, List<WMElement> paramList)
  {
    this.mContext = paramActivity;
    this.Mk = new ArrayList();
    int j;
    int i;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        paramActivity = (WMElement)paramList.next();
        j = WMEditItem.ITEM_TYPE_TEXT;
        i = j;
        if (paramActivity.logic != null)
        {
          i = j;
          if (paramActivity.logic.type != null)
          {
            if (!paramActivity.logic.type.equals("since")) {
              break label131;
            }
            i = WMEditItem.ITEM_TYPE_SINCE;
          }
        }
        label97:
        if (paramActivity.userValue != null) {
          paramActivity = paramActivity.userValue;
        }
      }
    }
    for (;;)
    {
      this.Mk.add(new WMEditItem(paramActivity, i));
      break;
      label131:
      i = j;
      if (!paramActivity.logic.type.equals("countdown")) {
        break label97;
      }
      i = WMEditItem.ITEM_TYPE_COUNTDOWN;
      break label97;
      if (i == WMEditItem.ITEM_TYPE_TEXT) {
        paramActivity = paramActivity.curValue;
      } else if (paramActivity.logic != null) {
        paramActivity = paramActivity.logic.compare;
      } else {
        paramActivity = "";
      }
    }
  }
  
  private void a(EditText paramEditText, WMEditItem paramWMEditItem)
  {
    this.bL.setTextColor(-1);
    this.bL = paramEditText;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem = paramWMEditItem;
    this.bL.setCursorVisible(true);
    if (this.jdField_a_of_type_Axaw$b != null) {
      this.jdField_a_of_type_Axaw$b.eIw();
    }
  }
  
  private void a(WMElement paramWMElement, axaw.a parama)
  {
    aqju localaqju = new aqju(this.bL.getContext(), 2131756467);
    localaqju.setContentView(2131559151);
    localaqju.setTitle(acfp.m(2131716894));
    localaqju.setMessage(acfp.m(2131716899));
    localaqju.setNegativeButton(acfp.m(2131716895), new axbb(this));
    localaqju.setPositiveButton(acfp.m(2131716896), new axbc(this, parama, paramWMElement));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.show();
  }
  
  private void h(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.postDelayed(new WatermarkEditListAdapter.7(this, paramEditText), 200L);
    }
  }
  
  private void i(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setCustomSelectionActionModeCallback(new axbd(this));
    }
  }
  
  public void a(axaw.b paramb)
  {
    this.jdField_a_of_type_Axaw$b = paramb;
  }
  
  public void eIv()
  {
    if ((!this.Mk.isEmpty()) && (this.bL != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem != null))
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType == WMEditItem.ITEM_TYPE_TEXT) {
        break label83;
      }
      this.bL.setTextColor(-12339461);
      if (this.jdField_a_of_type_Axaw$b != null) {
        this.jdField_a_of_type_Axaw$b.a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.bL);
      }
    }
    label83:
    do
    {
      return;
      this.bL.requestFocus();
      this.bL.setSelection(this.bL.getText().toString().length());
      ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).showSoftInput(this.bL, 1);
    } while (this.jdField_a_of_type_Axaw$b == null);
    this.jdField_a_of_type_Axaw$b.eIw();
  }
  
  public String gQ(int paramInt)
  {
    if ((this.Mk != null) && (paramInt < this.Mk.size())) {
      return ((WMEditItem)this.Mk.get(paramInt)).value;
    }
    return "";
  }
  
  public int getItemCount()
  {
    if (this.Mk == null) {
      return 0;
    }
    return this.Mk.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    axaw.a locala = (axaw.a)paramViewHolder;
    if (paramInt == 0)
    {
      this.bL = locala.editText;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem = ((WMEditItem)this.Mk.get(paramInt));
      if (getItemCount() == 1) {
        this.bL.setSingleLine(false);
      }
    }
    if (paramInt == getItemCount() - 1) {
      locala.HZ.setVisibility(8);
    }
    WMEditItem localWMEditItem = (WMEditItem)this.Mk.get(paramInt);
    locala.hT.setOnClickListener(new axax(this, paramInt, locala));
    if (localWMEditItem.itemType != WMEditItem.ITEM_TYPE_TEXT)
    {
      locala.hT.setVisibility(4);
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      Object localObject1 = null;
      try
      {
        localObject2 = localSimpleDateFormat.format(((SimpleDateFormat)localObject2).parse(localWMEditItem.value));
        localObject1 = localObject2;
      }
      catch (ParseException localParseException)
      {
        for (;;)
        {
          localParseException.printStackTrace();
        }
      }
      locala.editText.setText(localObject1);
      locala.editText.setFocusable(false);
      locala.editText.setCursorVisible(false);
      locala.editText.setOnClickListener(new axay(this, locala, localWMEditItem));
      i(locala.editText);
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    if ((localWMEditItem.value == null) || (localWMEditItem.value.equals("")))
    {
      locala.editText.setText(((WMElement)LogicDataManager.getInstance().getEditableWMElement().get(paramInt)).getDefault());
      label299:
      if ((LogicDataManager.getInstance().getEditableWMElement() == null) || (LogicDataManager.getInstance().getEditableWMElement().size() <= 0) || (!((WMElement)LogicDataManager.getInstance().getEditableWMElement().get(paramInt)).ischeckin)) {
        break label440;
      }
      locala.editText.setFocusable(false);
      locala.editText.setFocusableInTouchMode(false);
      locala.hT.setBackgroundResource(2130837945);
      locala.hT.setVisibility(0);
    }
    for (;;)
    {
      locala.editText.setOnFocusChangeListener(new axaz(this, locala, localWMEditItem));
      locala.editText.setOnClickListener(new axba(this, locala, localWMEditItem));
      break;
      locala.editText.setText(localWMEditItem.value);
      break label299;
      label440:
      locala.editText.setFocusable(true);
      locala.editText.setFocusableInTouchMode(true);
      locala.editText.requestFocus();
      locala.hT.setBackgroundResource(2130837943);
      locala.hT.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new axaw.a(LayoutInflater.from(this.mContext).inflate(2131558564, paramViewGroup, false));
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    label82:
    StringBuilder localStringBuilder;
    if ((this.bL != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem != null))
    {
      localObject = new StringBuilder().append(paramInt1).append(acfp.m(2131716898));
      if (paramInt2 + 1 >= 10) {
        break label202;
      }
      paramDatePicker = "0";
      localObject = ((StringBuilder)localObject).append(paramDatePicker).append(paramInt2 + 1).append(acfp.m(2131716893));
      if (paramInt3 >= 10) {
        break label208;
      }
      paramDatePicker = "0";
      localObject = paramDatePicker + paramInt3 + acfp.m(2131716897);
      localStringBuilder = new StringBuilder().append(paramInt1).append("-");
      if (paramInt2 + 1 >= 10) {
        break label214;
      }
      paramDatePicker = "0";
      label138:
      localStringBuilder = localStringBuilder.append(paramDatePicker).append(paramInt2 + 1).append("-");
      if (paramInt3 >= 10) {
        break label220;
      }
    }
    label202:
    label208:
    label214:
    label220:
    for (paramDatePicker = "0";; paramDatePicker = "")
    {
      paramDatePicker = paramDatePicker + paramInt3;
      this.bL.setText((CharSequence)localObject);
      this.bL.setTag(paramDatePicker);
      return;
      paramDatePicker = "";
      break;
      paramDatePicker = "";
      break label82;
      paramDatePicker = "";
      break label138;
    }
  }
  
  public class a
    extends RecyclerView.ViewHolder
  {
    public ImageView HZ;
    public boolean dtU;
    public EditText editText;
    public Button hT;
    
    public a(View paramView)
    {
      super();
      this.editText = ((EditText)paramView.findViewById(2131366257));
      this.HZ = ((ImageView)paramView.findViewById(2131365990));
      this.hT = ((Button)paramView.findViewById(2131377184));
      this.dtU = false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString, EditText paramEditText);
    
    public abstract void eIw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axaw
 * JD-Core Version:    0.7.0.1
 */