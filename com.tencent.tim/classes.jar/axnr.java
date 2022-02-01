import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tavsticker.core.TAVPAGFileManager;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.4;
import mqq.os.MqqHandler;
import org.libpag.PAGFile;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class axnr
  extends ReportDialog
{
  private View MN;
  private View MO;
  private axnr.a jdField_a_of_type_Axnr$a;
  private axnr.b jdField_a_of_type_Axnr$b;
  private String aRO;
  private AEEditorColorSelectorView b;
  private EditText bl;
  private boolean cSH = axiz.aOK();
  private String cVA;
  private String cVB;
  private View mRootView;
  private PAGView pagView;
  
  public axnr(@NonNull Context paramContext, int paramInt, axnr.a parama)
  {
    super(paramContext, paramInt);
    this.mRootView = LayoutInflater.from(paramContext).inflate(2131558617, null);
    this.jdField_a_of_type_Axnr$a = parama;
    eNb();
    setContentView(this.mRootView);
  }
  
  private void eMY()
  {
    if (this.jdField_a_of_type_Axnr$b == null)
    {
      axiy.e("AEEditorTextEditDialog", "originTextData is null.");
      return;
    }
    Object localObject = this.jdField_a_of_type_Axnr$b.getContent().trim();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    PAGText localPAGText;
    for (String str = this.aRO;; str = this.jdField_a_of_type_Axnr$b.getContent())
    {
      float f = 1.0F;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        f = 0.5F;
      }
      this.pagView.setAlpha(f);
      localObject = TAVPAGFileManager.getInstance().getPAGFileFromAsset(getContext(), "ae_editor_text_main.pag");
      if (localObject == null) {
        break;
      }
      localPAGText = ((PAGFile)localObject).getTextData(0);
      if (localPAGText != null) {
        break label106;
      }
      axiy.e("AEEditorTextEditDialog", "pagText is null.");
      return;
    }
    label106:
    localPAGText.text = str;
    localPAGText.fillColor = this.jdField_a_of_type_Axnr$b.getFontColor();
    ThreadManager.getUIHandler().post(new AEEditorTextEditDialog.4(this, (PAGFile)localObject, localPAGText));
  }
  
  private void eMZ()
  {
    if (this.jdField_a_of_type_Axnr$b == null) {
      axiy.e("AEEditorTextEditDialog", "originTextData is null.");
    }
    for (;;)
    {
      return;
      String str = this.jdField_a_of_type_Axnr$b.getContent();
      Object localObject = str;
      if (TextUtils.isEmpty(str.trim())) {
        localObject = this.aRO;
      }
      int i = this.jdField_a_of_type_Axnr$b.getFontColor();
      if (TextUtils.isEmpty(this.cVB)) {}
      for (localObject = new axno((String)localObject, "default_font", "", "default_style_1", i, ""); this.jdField_a_of_type_Axnr$a != null; localObject = new axoa(this.cVB, (String)localObject, "default_font", "", "default_style_1", i, ""))
      {
        this.jdField_a_of_type_Axnr$a.a((axob)localObject);
        return;
      }
    }
  }
  
  private void eNa()
  {
    this.bl.addTextChangedListener(new axnv(this));
  }
  
  private void eNb()
  {
    Window localWindow = getWindow();
    if (localWindow == null) {
      return;
    }
    requestWindowFeature(1);
    localWindow.setBackgroundDrawableResource(17170445);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.alpha = 1.0F;
    localLayoutParams.dimAmount = 1.0F;
    localWindow.setAttributes(localLayoutParams);
  }
  
  private void init()
  {
    this.cVA = getContext().getResources().getString(2131695676);
    this.aRO = getContext().getResources().getString(2131692456);
    this.MN = this.mRootView.findViewById(2131369705);
    this.MO = this.mRootView.findViewById(2131380709);
    this.bl = ((EditText)this.mRootView.findViewById(2131366532));
    this.pagView = ((PAGView)this.mRootView.findViewById(2131379261));
    this.b = ((AEEditorColorSelectorView)this.mRootView.findViewById(2131364927));
    this.pagView.play();
    this.pagView.setRepeatCount(0);
    this.b.setColorSelectedListener(new axns(this));
    this.MN.setOnClickListener(new axnt(this));
    this.MO.setOnClickListener(new axnu(this));
    eNa();
    if (this.jdField_a_of_type_Axnr$b != null)
    {
      this.b.setSelectedColor(this.jdField_a_of_type_Axnr$b.getFontColor());
      this.bl.setText(this.jdField_a_of_type_Axnr$b.getContent());
      if (this.jdField_a_of_type_Axnr$b.getContent() != null) {
        this.bl.setSelection(this.jdField_a_of_type_Axnr$b.getContent().length());
      }
    }
    if (this.jdField_a_of_type_Axnr$b == null)
    {
      this.jdField_a_of_type_Axnr$b = new axnr.b();
      this.b.setSelectedColor(-1);
    }
    this.bl.setHint(this.aRO);
    eMY();
  }
  
  public void a(String paramString, axnr.b paramb)
  {
    this.cVB = paramString;
    if (paramb != null) {
      this.jdField_a_of_type_Axnr$b = paramb;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    init();
  }
  
  public void onResume()
  {
    eMY();
  }
  
  public static abstract interface a
  {
    public abstract void a(axob paramaxob);
  }
  
  public static class b
  {
    private String Nl = "";
    private String content = "";
    private int fontColor = -1;
    private String fontId = "";
    
    public void aer(int paramInt)
    {
      this.fontColor = paramInt;
    }
    
    public String getContent()
    {
      return this.content;
    }
    
    public int getFontColor()
    {
      return this.fontColor;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnr
 * JD-Core Version:    0.7.0.1
 */