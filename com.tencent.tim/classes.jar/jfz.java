import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.av.ui.chatroom.VideoChatRoomListView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jfz
  implements afmf, Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener
{
  public boolean Zd;
  private final auru jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  private VideoChatRoomListView jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView;
  private jfz.a jdField_a_of_type_Jfz$a;
  private ViewGroup aG;
  private final int ayM = 2130843012;
  private final int ayN = 2130843014;
  private int ayO = 0;
  private int ayP = 0;
  private int ayQ = -1;
  private int ayR = -1;
  private final Point b = new Point();
  private final InputMethodManager c;
  private ImageView gR;
  private final Activity mActivity;
  private EditText mEditText;
  private final Rect mTemp = new Rect();
  
  private jfz(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.c = ((InputMethodManager)paramActivity.getSystemService("input_method"));
    this.mActivity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    if (Build.VERSION.SDK_INT <= 18) {
      this.Zd = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "EmotionInputDetector, ARMode2[" + this.Zd + "], sdk[" + Build.VERSION.SDK_INT + "]");
    }
  }
  
  private void B(int paramInt, long paramLong)
  {
    if (this.ayP != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, String.format("updateInputPanelState, [%s --> %s], seq[%s], soft[%s]", new Object[] { Integer.valueOf(this.ayP), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(this.ayO) }));
      }
      this.ayP = paramInt;
      if (this.jdField_a_of_type_Jfz$a != null) {
        this.jdField_a_of_type_Jfz$a.C(this.ayP, paramLong);
      }
    }
  }
  
  public static jfz a(Activity paramActivity)
  {
    return new jfz(paramActivity);
  }
  
  private void avS()
  {
    aofr localaofr = null;
    Object localObject = this.mEditText.getText();
    if ((localObject instanceof aofr))
    {
      localaofr = (aofr)localObject;
      localObject = null;
    }
    for (;;)
    {
      if (localaofr != null) {
        localObject = ily.a(localaofr);
      }
      this.mEditText.setText("");
      if ((this.jdField_a_of_type_Jfz$a != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_a_of_type_Jfz$a.kr((String)localObject);
      }
      return;
      localObject = localObject.toString();
      if (aofy.Z((String)localObject)) {
        localaofr = new aofr((CharSequence)localObject, 3, 16);
      }
    }
  }
  
  private void avT()
  {
    long l = AudioHelper.hG();
    if (this.jdField_a_of_type_Auru.hasMessages(2)) {
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, "showEmotionLayout, is to show. seq[" + l + "]");
      }
    }
    do
    {
      return;
      if (!xg()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatRoomUtil", 2, "showEmotionLayout, is showing. seq[" + l + "]");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "showEmotionLayout, isSoftKeyboardShown[" + xh() + "], seq[" + l + "]");
    }
    this.gR.setImageResource(2130843014);
    if (xh())
    {
      B(5, l);
      avY();
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.arg1 = 0;
      localMessage.arg2 = 0;
      this.jdField_a_of_type_Auru.sendMessageDelayed(localMessage, 100L);
      return;
    }
    avU();
  }
  
  private void avU()
  {
    long l = AudioHelper.hG();
    this.gR.setImageResource(2130843014);
    this.aG.setVisibility(0);
    B(4, l);
  }
  
  private void avW()
  {
    View localView1 = this.mActivity.getWindow().getDecorView();
    View localView2 = localView1.getRootView();
    localView2.getWindowVisibleDisplayFrame(this.mTemp);
    int i = localView2.getRootView().getHeight();
    int j = i - this.mTemp.height();
    label73:
    label86:
    long l;
    if (j > i / 4)
    {
      i = 1;
      if (j > 0)
      {
        if (this.ayQ != -1) {
          break label494;
        }
        this.ayQ = j;
        if (this.ayR != -1) {
          break label510;
        }
        this.ayR = j;
        if ((this.ayQ == this.ayR) && (this.mTemp.top > 0)) {
          this.ayQ = this.mTemp.top;
        }
      }
      if (i != this.ayO)
      {
        l = AudioHelper.hG();
        if (i == 1)
        {
          this.mActivity.getWindowManager().getDefaultDisplay().getSize(this.b);
          ily.aoW = Math.max(this.b.y - this.mTemp.bottom, this.ayR - this.ayQ);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("updateSoftKeyboardState, seq[%s], [%s --> %s], inputPanelState[%s], height[%s], KeyBoardHeight[%s], ARMode2[%s], decorView[%s, %s, %s, %s], s[%s, %s], temp[%s, %s, %s, %s], diff[%s, %s]", new Object[] { Long.valueOf(l), Integer.valueOf(this.ayO), Integer.valueOf(i), Integer.valueOf(this.ayP), Integer.valueOf(j), Integer.valueOf(ily.aoW), Boolean.valueOf(this.Zd), Integer.valueOf(localView1.getLeft()), Integer.valueOf(localView1.getTop()), Integer.valueOf(localView1.getRight()), Integer.valueOf(localView1.getBottom()), Integer.valueOf(this.b.x), Integer.valueOf(this.b.y), Integer.valueOf(this.mTemp.left), Integer.valueOf(this.mTemp.top), Integer.valueOf(this.mTemp.right), Integer.valueOf(this.mTemp.bottom), Integer.valueOf(this.ayQ), Integer.valueOf(this.ayR) }));
        }
        j = this.ayO;
        this.ayO = i;
        if (this.ayO != 1) {
          break label526;
        }
        this.jdField_a_of_type_Auru.removeMessages(2);
        B(2, l);
        if (xg()) {
          avV();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Jfz$a != null) {
        this.jdField_a_of_type_Jfz$a.d(j, i, this.ayP, l);
      }
      return;
      i = 2;
      break;
      label494:
      if (this.ayQ <= j) {
        break label73;
      }
      this.ayQ = j;
      break label73;
      label510:
      if (this.ayR >= j) {
        break label86;
      }
      this.ayR = j;
      break label86;
      label526:
      if (this.ayP == 5)
      {
        this.jdField_a_of_type_Auru.removeMessages(2);
        avU();
      }
      else if (xg())
      {
        B(4, l);
      }
      else
      {
        B(7, l);
      }
    }
  }
  
  private void avX()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("showSoftKeyboard, seq[%s], emotion[%s], soft[%s]", new Object[] { Long.valueOf(l), Boolean.valueOf(xg()), Boolean.valueOf(xh()) }));
    }
    if (xh()) {
      return;
    }
    this.mEditText.setFocusable(true);
    this.mEditText.setFocusableInTouchMode(true);
    this.mEditText.requestFocus();
    if (this.c != null) {
      this.c.showSoftInput(this.mEditText, 1);
    }
    if (!TextUtils.isEmpty(this.mEditText.getText())) {
      this.mEditText.setSelection(this.mEditText.getText().length());
    }
    if (xg())
    {
      B(6, l);
      avV();
      return;
    }
    B(1, l);
  }
  
  public jfz a()
  {
    this.mActivity.getWindow().setSoftInputMode(19);
    return this;
  }
  
  public jfz a(ViewGroup paramViewGroup)
  {
    this.aG = paramViewGroup;
    return this;
  }
  
  public jfz a(EditText paramEditText)
  {
    this.mEditText = paramEditText;
    this.mEditText.setFocusable(true);
    this.mEditText.setFocusableInTouchMode(true);
    this.mEditText.requestFocus();
    this.mEditText.setEditableFactory(aofr.a(16));
    this.mEditText.setOnClickListener(new jga(this));
    this.mEditText.addTextChangedListener(new jgb(this));
    this.mEditText.setOnKeyListener(new jgc(this));
    return this;
  }
  
  public jfz a(ImageView paramImageView)
  {
    this.gR = paramImageView;
    this.gR.setImageResource(2130843012);
    this.gR.setOnClickListener(new jgd(this));
    return this;
  }
  
  public jfz a(VideoChatRoomListView paramVideoChatRoomListView)
  {
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView = paramVideoChatRoomListView;
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView.setOnDispatchTouchEventResponseListener(new jge(this));
    return this;
  }
  
  public jfz a(jfz.a parama)
  {
    this.jdField_a_of_type_Jfz$a = parama;
    return this;
  }
  
  public void a(afmi paramafmi)
  {
    if ((paramafmi instanceof afqr)) {
      ((afqr)paramafmi).a(null, this.mActivity, this.mEditText, null);
    }
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return false;
  }
  
  public void avV()
  {
    long l = AudioHelper.hG();
    if (xg())
    {
      this.gR.setImageResource(2130843012);
      this.aG.setVisibility(8);
      if ((this.ayP != 6) && (!xh())) {
        B(7, l);
      }
    }
  }
  
  public void avY()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "hideSoftKeyboard, soft[" + xh() + "], seq[" + l + "]");
    }
    if (xh())
    {
      this.mEditText.clearFocus();
      this.c.hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
      if (this.ayP != 5) {
        B(3, l);
      }
    }
  }
  
  public void b(afmi paramafmi) {}
  
  public void clearFocus()
  {
    this.mEditText.clearFocus();
  }
  
  public void delete()
  {
    aofy.g(this.mEditText);
  }
  
  public void gq() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if ((!xh()) || (paramMessage.arg1 != 0)) {
        break label55;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      paramMessage.arg1 += 1;
      this.jdField_a_of_type_Auru.sendMessageDelayed(localMessage, 100L);
    }
    for (;;)
    {
      return true;
      label55:
      avU();
    }
  }
  
  public int mq()
  {
    return this.ayP;
  }
  
  public void onGlobalLayout()
  {
    avW();
  }
  
  public void send()
  {
    avS();
  }
  
  public void setting() {}
  
  public boolean xf()
  {
    boolean bool2 = xg();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = xh();
    }
    return bool1;
  }
  
  public boolean xg()
  {
    return (this.aG != null) && (this.aG.getVisibility() == 0);
  }
  
  public boolean xh()
  {
    if (this.ayO == 0) {
      avW();
    }
    return this.ayO == 1;
  }
  
  public static abstract interface a
  {
    public abstract void C(int paramInt, long paramLong);
    
    public abstract void d(int paramInt1, int paramInt2, int paramInt3, long paramLong);
    
    public abstract void kr(String paramString);
    
    public abstract void z(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfz
 * JD-Core Version:    0.7.0.1
 */