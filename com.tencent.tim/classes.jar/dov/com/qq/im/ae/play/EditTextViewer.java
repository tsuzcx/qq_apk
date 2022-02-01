package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import aqhq;
import axbm;
import axhu;
import axhz;
import axia;
import axib;
import axim;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;
import com.tencent.ttpic.openapi.util.WMTextDrawer;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import java.io.File;

public class EditTextViewer
  extends ImageView
  implements View.OnClickListener
{
  private static final String TAG = EditTextViewer.class.getSimpleName();
  private a jdField_a_of_type_DovComQqImAePlayEditTextViewer$a;
  private b jdField_a_of_type_DovComQqImAePlayEditTextViewer$b;
  private axhu jdField_b_of_type_Axhu;
  private NodeItem jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem = new NodeItem();
  private String cUC;
  private boolean duL;
  private boolean duM = true;
  private boolean duN;
  private LayerDrawable f;
  private Drawable hf;
  private Bitmap hn;
  private boolean inited;
  private int mActionBarHeight;
  private Activity mActivity;
  private Matrix mMatrix = new Matrix();
  private String mTemplateID;
  private TextWMElement mTextWMElement = new TextWMElement();
  private String materialId;
  
  public EditTextViewer(Context paramContext)
  {
    super(paramContext);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    this.duM = true;
    setBackgroundDrawable(getResources().getDrawable(2130837941));
    this.f = ((LayerDrawable)getResources().getDrawable(2130837940));
    this.hf = this.f.findDrawableByLayerId(2131368904);
  }
  
  private String a(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "temp.ttf";
    aqhq.writeFile(paramArrayOfByte, paramContext);
    return paramContext;
  }
  
  private void a(GetFontDataRsp paramGetFontDataRsp)
  {
    paramGetFontDataRsp = a(getContext(), paramGetFontDataRsp.FontData);
    if (!TextUtils.isEmpty(paramGetFontDataRsp))
    {
      this.mTextWMElement.fontName = paramGetFontDataRsp;
      this.mTextWMElement.isLocalFont = false;
    }
    try
    {
      this.mTextWMElement.wmTextDrawer.drawTextToBitmap(this.mTextWMElement, getValue(), false, true);
      this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap = this.mTextWMElement.getBitmap();
      if (!TextUtils.isEmpty(paramGetFontDataRsp))
      {
        ue(paramGetFontDataRsp);
        this.mTextWMElement.fontName = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontName;
        this.mTextWMElement.isLocalFont = true;
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.e(TAG, "drawText of drawTextToBitmap Error, maybe use a recycle bitmap!");
      }
    }
  }
  
  private void adU(int paramInt)
  {
    this.mActivity.runOnUiThread(new EditTextViewer.5(this, paramInt));
  }
  
  private void bU(Canvas paramCanvas)
  {
    if (!this.duN) {
      return;
    }
    this.f.setBounds(0, 0, getWidth(), getHeight());
    this.f.draw(paramCanvas);
  }
  
  private void drawText()
  {
    String str1 = this.mTextWMElement.fontName;
    String str2 = this.mTextWMElement.userValue;
    AppInterface localAppInterface = QQStoryContext.c();
    localAppInterface.addObserver(new axib(this, localAppInterface, str2));
    ((axbm)localAppInterface.getBusinessHandler(3)).jK(str1, str2);
  }
  
  private void eKi()
  {
    if (this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$a != null) {
      this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$a.eKi();
    }
  }
  
  private void eKj()
  {
    if (this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$a != null) {
      this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$a.eKj();
    }
  }
  
  private void eKp()
  {
    if (this.mTextWMElement != null)
    {
      this.jdField_b_of_type_Axhu = new axhu(this.mActivity);
      this.jdField_b_of_type_Axhu.adT(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextMaxCount);
      this.jdField_b_of_type_Axhu.a(this.mTextWMElement, this.duM);
      this.jdField_b_of_type_Axhu.a(new axhz(this));
      this.jdField_b_of_type_Axhu.show();
      this.jdField_b_of_type_Axhu.setOnDismissListener(new axia(this));
    }
  }
  
  private void eKq()
  {
    if (this.hn == null) {
      this.hn = Bitmap.createBitmap(this.mTextWMElement.width, this.mTextWMElement.height, Bitmap.Config.ARGB_8888);
    }
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap = this.hn;
  }
  
  private void eKr()
  {
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap = null;
    if (this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) {
      setImageBitmap(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap);
    }
    if (this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$b != null) {
      this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$b.b(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
    }
    setTextSelected(true);
    this.duM = false;
  }
  
  private String getValue()
  {
    String str;
    if (this.mTextWMElement.userValue != null) {
      str = this.mTextWMElement.userValue;
    }
    do
    {
      return str;
      str = "";
    } while (this.mTextWMElement.fmtstr == null);
    return new String(this.mTextWMElement.fmtstr);
  }
  
  private boolean ue(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      bool1 = bool2;
      if (paramString.isFile())
      {
        bool1 = bool2;
        if (paramString.delete()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public NodeItem a()
  {
    return this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem;
  }
  
  public Bitmap aV()
  {
    if (!this.inited) {
      eKn();
    }
    try
    {
      this.mTextWMElement.wmTextDrawer.drawTextToBitmap(this.mTextWMElement, getValue(), false, true);
      return this.mTextWMElement.getBitmap();
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.e(TAG, "renderBitmap of drawTextToBitmap Error, maybe use a recycle bitmap!");
      }
    }
  }
  
  public void acG(String paramString)
  {
    if (!DeviceUtils.isNetworkAvailable(AEModule.getContext())) {
      QQToast.a(getContext(), 2131690010, 1).show();
    }
    label131:
    for (;;)
    {
      return;
      if (!this.inited) {
        eKn();
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (this.mTextWMElement.userValue = "";; this.mTextWMElement.userValue = paramString)
      {
        if (this.mTextWMElement.userValue.equals(this.cUC)) {
          break label131;
        }
        if (!TextUtils.isEmpty(this.mTextWMElement.userValue)) {
          break label133;
        }
        this.cUC = this.mTextWMElement.userValue;
        eKq();
        eKr();
        if (this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$b == null) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$b.c(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
        return;
      }
    }
    label133:
    eKi();
    new Thread(new EditTextViewer.3(this)).start();
  }
  
  public void eKn()
  {
    boolean bool2 = false;
    if (this.mTextWMElement == null)
    {
      this.inited = false;
      return;
    }
    label64:
    boolean bool1;
    if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.id))
    {
      this.mTextWMElement.id = ("text" + this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeID);
      this.mTextWMElement.relativeID = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.relativeID;
      this.mTextWMElement.relativeAnchor = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.relativeAnchor;
      this.mTextWMElement.anchor = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.anchor;
      this.mTextWMElement.offsetX = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.offsetX;
      this.mTextWMElement.offsetY = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.offsetY;
      this.mTextWMElement.width = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.width;
      this.mTextWMElement.height = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.height;
      this.mTextWMElement.edittype = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.editType;
      this.mTextWMElement.fontSize = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontSize;
      this.mTextWMElement.fontFit = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontFit;
      this.mTextWMElement.wmtype = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.wmtype;
      this.mTextWMElement.fmtstr = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fmtstr;
      this.mTextWMElement.fontName = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontName;
      this.mTextWMElement.color = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.color;
      this.mTextWMElement.alignment = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment;
      this.mTextWMElement.vertical = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.vertical;
      TextWMElement localTextWMElement = this.mTextWMElement;
      if (this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontBold != 0) {
        break label592;
      }
      bool1 = false;
      label356:
      localTextWMElement.fontBold = bool1;
      localTextWMElement = this.mTextWMElement;
      if (this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontItalics != 0) {
        break label597;
      }
      bool1 = bool2;
      label381:
      localTextWMElement.fontItalics = bool1;
      this.mTextWMElement.strokeColor = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.strokeColor;
      this.mTextWMElement.strokeSize = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.strokeSize;
      this.mTextWMElement.outerStrokeColor = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.outerStrokeColor;
      this.mTextWMElement.outerStrokeSize = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.outerStrokeSize;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.shadowColor)) {
        break label602;
      }
    }
    label592:
    label597:
    label602:
    for (this.mTextWMElement.shadowColor = "#00000000";; this.mTextWMElement.shadowColor = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.shadowColor)
    {
      this.mTextWMElement.shadowDx = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.shadowDx;
      this.mTextWMElement.shadowDy = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.shadowDy;
      this.mTextWMElement.blurAmount = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.blurAmount;
      this.mTextWMElement.numberSource = "";
      this.mTextWMElement.init();
      this.inited = true;
      if (this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextMaxCount > 0) {
        break;
      }
      this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextMaxCount = 10;
      return;
      this.mTextWMElement.id = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.id;
      break label64;
      bool1 = true;
      break label356;
      bool1 = true;
      break label381;
    }
  }
  
  public void eKo()
  {
    if (this.mTextWMElement != null) {
      this.mTextWMElement.clear();
    }
  }
  
  public void eKs()
  {
    if ((this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) && (!this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.isRecycled())) {
      this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.recycle();
    }
    if ((this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap != null) && (!this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.isRecycled())) {
      this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.recycle();
    }
    setImageBitmap(null);
    eKo();
    this.inited = false;
  }
  
  public int getNodeGroupID()
  {
    return this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeGroupID;
  }
  
  public void lv(int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getWidth();
    int j = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getHeight();
    if (this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup != null) {
      if ("left".equals(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment))
      {
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
      }
    }
    for (;;)
    {
      this.mMatrix.postTranslate(paramInt2, paramInt1);
      setImageMatrix(this.mMatrix);
      return;
      if ("right".equals(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment))
      {
        i = paramInt1 - k;
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
      }
      else
      {
        i = paramInt1 / 2 - k / 2;
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
        continue;
        paramInt1 = 0;
        paramInt2 = i;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (!this.inited) {
      eKn();
    }
    eKp();
    setTextSelected(false);
    axim.a().eKE();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    label197:
    for (;;)
    {
      try
      {
        int m;
        int i;
        int n;
        int k;
        if ((this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) && (getWidth() != 0) && (getHeight() != 0))
        {
          m = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getWidth();
          i = this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getHeight();
          n = getWidth();
          k = getHeight();
          if (this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup == null) {
            break label197;
          }
          if ("left".equals(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment))
          {
            i = k / 2 - i / 2;
            this.mMatrix.postTranslate(j, i);
            setImageMatrix(this.mMatrix);
          }
        }
        else
        {
          super.onDraw(paramCanvas);
          bU(paramCanvas);
          return;
        }
        if ("right".equals(this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment))
        {
          j = n - m;
          i = k / 2 - i / 2;
        }
        else
        {
          j = n / 2 - m / 2;
          k /= 2;
          i /= 2;
          i = k - i;
          continue;
          i = 0;
        }
      }
      catch (Throwable paramCanvas)
      {
        return;
      }
    }
  }
  
  public void setActionBarHeight(int paramInt)
  {
    this.mActionBarHeight = paramInt;
  }
  
  public void setMaterialId(String paramString)
  {
    this.materialId = paramString;
  }
  
  public void setNodeBitmap(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap = paramBitmap;
  }
  
  public void setNodeInfo(NodeItem paramNodeItem)
  {
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeID = paramNodeItem.nodeID;
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeGroupID = paramNodeItem.nodeGroupID;
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.once = paramNodeItem.once;
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect = paramNodeItem.maskRect;
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.zIndex = paramNodeItem.zIndex;
    this.jdField_b_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.copyFrom(paramNodeItem.nodeTextGroup);
  }
  
  public void setOnDownloadDialogListener(a parama)
  {
    this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$a = parama;
  }
  
  public void setOnSaveTextInfoListener(b paramb)
  {
    this.jdField_a_of_type_DovComQqImAePlayEditTextViewer$b = paramb;
  }
  
  public void setTemplateID(String paramString)
  {
    this.mTemplateID = paramString;
  }
  
  public void setTextSelected(boolean paramBoolean)
  {
    this.duL = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void eKi();
    
    public abstract void eKj();
  }
  
  public static abstract interface b
  {
    public abstract void b(NodeItem paramNodeItem);
    
    public abstract void c(NodeItem paramNodeItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextViewer
 * JD-Core Version:    0.7.0.1
 */