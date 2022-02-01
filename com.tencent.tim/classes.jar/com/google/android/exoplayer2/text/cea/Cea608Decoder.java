package com.google.android.exoplayer2.text.cea;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class Cea608Decoder
  extends CeaDecoder
{
  private static final int[] BASIC_CHARACTER_SET = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int CC_FIELD_FLAG = 1;
  private static final byte CC_IMPLICIT_DATA_HEADER = -4;
  private static final int CC_MODE_PAINT_ON = 3;
  private static final int CC_MODE_POP_ON = 2;
  private static final int CC_MODE_ROLL_UP = 1;
  private static final int CC_MODE_UNKNOWN = 0;
  private static final int CC_TYPE_FLAG = 2;
  private static final int CC_VALID_608_ID = 4;
  private static final int CC_VALID_FLAG = 4;
  private static final int[] COLORS;
  private static final int[] COLUMN_INDICES;
  private static final byte CTRL_BACKSPACE = 33;
  private static final byte CTRL_CARRIAGE_RETURN = 45;
  private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
  private static final byte CTRL_END_OF_CAPTION = 47;
  private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
  private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
  private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
  private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
  private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
  private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
  private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
  private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
  private static final int NTSC_CC_FIELD_1 = 0;
  private static final int NTSC_CC_FIELD_2 = 1;
  private static final int[] ROW_INDICES = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] SPECIAL_CHARACTER_SET = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] SPECIAL_ES_FR_CHARACTER_SET = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] SPECIAL_PT_DE_CHARACTER_SET = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private int captionMode;
  private int captionRowCount;
  private final ParsableByteArray ccData = new ParsableByteArray();
  private final ArrayList<CueBuilder> cueBuilders = new ArrayList();
  private List<Cue> cues;
  private CueBuilder currentCueBuilder = new CueBuilder(0, 4);
  private List<Cue> lastCues;
  private final int packetLength;
  private byte repeatableControlCc1;
  private byte repeatableControlCc2;
  private boolean repeatableControlSet;
  private final int selectedField;
  
  static
  {
    COLUMN_INDICES = new int[] { 0, 4, 8, 12, 16, 20, 24, 28 };
    COLORS = new int[] { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  }
  
  public Cea608Decoder(String paramString, int paramInt)
  {
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.packetLength = i;
      switch (paramInt)
      {
      }
    }
    for (this.selectedField = 1;; this.selectedField = 2)
    {
      setCaptionMode(0);
      resetCueBuilders();
      return;
      i = 3;
      break;
    }
  }
  
  private static char getChar(byte paramByte)
  {
    return (char)BASIC_CHARACTER_SET[((paramByte & 0x7F) - 32)];
  }
  
  private List<Cue> getDisplayCues()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.cueBuilders.size())
    {
      Cue localCue = ((CueBuilder)this.cueBuilders.get(i)).build();
      if (localCue != null) {
        localArrayList.add(localCue);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static char getExtendedEsFrChar(byte paramByte)
  {
    return (char)SPECIAL_ES_FR_CHARACTER_SET[(paramByte & 0x1F)];
  }
  
  private static char getExtendedPtDeChar(byte paramByte)
  {
    return (char)SPECIAL_PT_DE_CHARACTER_SET[(paramByte & 0x1F)];
  }
  
  private static char getSpecialChar(byte paramByte)
  {
    return (char)SPECIAL_CHARACTER_SET[(paramByte & 0xF)];
  }
  
  private boolean handleCtrl(byte paramByte1, byte paramByte2)
  {
    boolean bool = isRepeatable(paramByte1);
    if (bool)
    {
      if ((this.repeatableControlSet) && (this.repeatableControlCc1 == paramByte1) && (this.repeatableControlCc2 == paramByte2))
      {
        this.repeatableControlSet = false;
        return true;
      }
      this.repeatableControlSet = true;
      this.repeatableControlCc1 = paramByte1;
      this.repeatableControlCc2 = paramByte2;
    }
    if (isMidrowCtrlCode(paramByte1, paramByte2)) {
      handleMidrowCtrl(paramByte2);
    }
    for (;;)
    {
      return bool;
      if (isPreambleAddressCode(paramByte1, paramByte2)) {
        handlePreambleAddressCode(paramByte1, paramByte2);
      } else if (isTabCtrlCode(paramByte1, paramByte2)) {
        this.currentCueBuilder.setTab(paramByte2 - 32);
      } else if (isMiscCode(paramByte1, paramByte2)) {
        handleMiscCode(paramByte2);
      }
    }
  }
  
  private void handleMidrowCtrl(byte paramByte)
  {
    if ((paramByte & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.currentCueBuilder.setUnderline(bool);
      paramByte = paramByte >> 1 & 0xF;
      if (paramByte != 7) {
        break;
      }
      this.currentCueBuilder.setMidrowStyle(new StyleSpan(2), 2);
      this.currentCueBuilder.setMidrowStyle(new ForegroundColorSpan(-1), 1);
      return;
    }
    this.currentCueBuilder.setMidrowStyle(new ForegroundColorSpan(COLORS[paramByte]), 1);
  }
  
  private void handleMiscCode(byte paramByte)
  {
    switch (paramByte)
    {
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 40: 
    default: 
      if (this.captionMode != 0) {
        break;
      }
    }
    do
    {
      do
      {
        return;
        setCaptionMode(1);
        setCaptionRowCount(2);
        return;
        setCaptionMode(1);
        setCaptionRowCount(3);
        return;
        setCaptionMode(1);
        setCaptionRowCount(4);
        return;
        setCaptionMode(2);
        return;
        setCaptionMode(3);
        return;
        switch (paramByte)
        {
        case 36: 
        default: 
          return;
        case 33: 
          this.currentCueBuilder.backspace();
          return;
        case 44: 
          this.cues = null;
        }
      } while ((this.captionMode != 1) && (this.captionMode != 3));
      resetCueBuilders();
      return;
      resetCueBuilders();
      return;
      this.cues = getDisplayCues();
      resetCueBuilders();
      return;
    } while ((this.captionMode != 1) || (this.currentCueBuilder.isEmpty()));
    this.currentCueBuilder.rollUp();
  }
  
  private void handlePreambleAddressCode(byte paramByte1, byte paramByte2)
  {
    int j = ROW_INDICES[(paramByte1 & 0x7)];
    if ((paramByte2 & 0x20) != 0) {}
    for (paramByte1 = 1;; paramByte1 = 0)
    {
      int i = j;
      if (paramByte1 != 0) {
        i = j + 1;
      }
      if (i != this.currentCueBuilder.getRow())
      {
        if ((this.captionMode != 1) && (!this.currentCueBuilder.isEmpty()))
        {
          this.currentCueBuilder = new CueBuilder(this.captionMode, this.captionRowCount);
          this.cueBuilders.add(this.currentCueBuilder);
        }
        this.currentCueBuilder.setRow(i);
      }
      if ((paramByte2 & 0x1) == 1) {
        this.currentCueBuilder.setPreambleStyle(new UnderlineSpan());
      }
      paramByte1 = paramByte2 >> 1 & 0xF;
      if (paramByte1 > 7) {
        break label195;
      }
      if (paramByte1 != 7) {
        break;
      }
      this.currentCueBuilder.setPreambleStyle(new StyleSpan(2));
      this.currentCueBuilder.setPreambleStyle(new ForegroundColorSpan(-1));
      return;
    }
    this.currentCueBuilder.setPreambleStyle(new ForegroundColorSpan(COLORS[paramByte1]));
    return;
    label195:
    this.currentCueBuilder.setIndent(COLUMN_INDICES[(paramByte1 & 0x7)]);
  }
  
  private static boolean isMidrowCtrlCode(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 17) && ((paramByte2 & 0xF0) == 32);
  }
  
  private static boolean isMiscCode(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 20) && ((paramByte2 & 0xF0) == 32);
  }
  
  private static boolean isPreambleAddressCode(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF0) == 16) && ((paramByte2 & 0xC0) == 64);
  }
  
  private static boolean isRepeatable(byte paramByte)
  {
    return (paramByte & 0xF0) == 16;
  }
  
  private static boolean isTabCtrlCode(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 23) && (paramByte2 >= 33) && (paramByte2 <= 35);
  }
  
  private void resetCueBuilders()
  {
    this.currentCueBuilder.reset(this.captionMode);
    this.cueBuilders.clear();
    this.cueBuilders.add(this.currentCueBuilder);
  }
  
  private void setCaptionMode(int paramInt)
  {
    if (this.captionMode == paramInt) {}
    int i;
    do
    {
      return;
      i = this.captionMode;
      this.captionMode = paramInt;
      resetCueBuilders();
    } while ((i != 3) && (paramInt != 1) && (paramInt != 0));
    this.cues = null;
  }
  
  private void setCaptionRowCount(int paramInt)
  {
    this.captionRowCount = paramInt;
    this.currentCueBuilder.setCaptionRowCount(paramInt);
  }
  
  protected Subtitle createSubtitle()
  {
    this.lastCues = this.cues;
    return new CeaSubtitle(this.cues);
  }
  
  protected void decode(SubtitleInputBuffer paramSubtitleInputBuffer)
  {
    this.ccData.reset(paramSubtitleInputBuffer.data.array(), paramSubtitleInputBuffer.data.limit());
    boolean bool = false;
    int k = 0;
    while (this.ccData.bytesLeft() >= this.packetLength)
    {
      if (this.packetLength == 2) {}
      int i;
      int j;
      for (int m = -4;; m = (byte)this.ccData.readUnsignedByte())
      {
        i = (byte)(this.ccData.readUnsignedByte() & 0x7F);
        j = (byte)(this.ccData.readUnsignedByte() & 0x7F);
        if (((m & 0x6) != 4) || ((this.selectedField == 1) && ((m & 0x1) != 0)) || ((this.selectedField == 2) && ((m & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label175;
        }
        this.currentCueBuilder.append(getSpecialChar(j));
        k = 1;
        break;
      }
      label175:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.currentCueBuilder.backspace();
        if ((i & 0x1) == 0)
        {
          this.currentCueBuilder.append(getExtendedEsFrChar(j));
          k = 1;
        }
        else
        {
          this.currentCueBuilder.append(getExtendedPtDeChar(j));
          k = 1;
        }
      }
      else if ((i & 0xE0) == 0)
      {
        bool = handleCtrl(i, j);
        k = 1;
      }
      else
      {
        this.currentCueBuilder.append(getChar(i));
        if ((j & 0xE0) != 0) {
          this.currentCueBuilder.append(getChar(j));
        }
        k = 1;
      }
    }
    if (k != 0)
    {
      if (!bool) {
        this.repeatableControlSet = false;
      }
      if ((this.captionMode == 1) || (this.captionMode == 3)) {
        this.cues = getDisplayCues();
      }
    }
  }
  
  public void flush()
  {
    super.flush();
    this.cues = null;
    this.lastCues = null;
    setCaptionMode(0);
    setCaptionRowCount(4);
    resetCueBuilders();
    this.repeatableControlSet = false;
    this.repeatableControlCc1 = 0;
    this.repeatableControlCc2 = 0;
  }
  
  public String getName()
  {
    return "Cea608Decoder";
  }
  
  protected boolean isNewSubtitleDataAvailable()
  {
    return this.cues != this.lastCues;
  }
  
  public void release() {}
  
  static class CueBuilder
  {
    private static final int BASE_ROW = 15;
    private static final int POSITION_UNSET = -1;
    private static final int SCREEN_CHARWIDTH = 32;
    private int captionMode;
    private int captionRowCount;
    private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();
    private int indent;
    private final List<CueStyle> midrowStyles = new ArrayList();
    private final List<CharacterStyle> preambleStyles = new ArrayList();
    private final List<SpannableString> rolledUpCaptions = new ArrayList();
    private int row;
    private int tabOffset;
    private int underlineStartPosition;
    
    public CueBuilder(int paramInt1, int paramInt2)
    {
      reset(paramInt1);
      setCaptionRowCount(paramInt2);
    }
    
    public void append(char paramChar)
    {
      this.captionStringBuilder.append(paramChar);
    }
    
    public void backspace()
    {
      int i = this.captionStringBuilder.length();
      if (i > 0) {
        this.captionStringBuilder.delete(i - 1, i);
      }
    }
    
    public Cue build()
    {
      int k = 2;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int i = 0;
      while (i < this.rolledUpCaptions.size())
      {
        localSpannableStringBuilder.append((CharSequence)this.rolledUpCaptions.get(i));
        localSpannableStringBuilder.append('\n');
        i += 1;
      }
      localSpannableStringBuilder.append(buildSpannableString());
      if (localSpannableStringBuilder.length() == 0) {
        return null;
      }
      i = this.indent + this.tabOffset;
      int j = 32 - i - localSpannableStringBuilder.length();
      int m = i - j;
      float f;
      if ((this.captionMode == 2) && ((Math.abs(m) < 3) || (j < 0)))
      {
        f = 0.5F;
        i = 1;
        if ((this.captionMode != 1) && (this.row <= 7)) {
          break label232;
        }
        j = this.row - 15 - 2;
      }
      for (;;)
      {
        return new Cue(localSpannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, j, 1, k, f, i, 1.4E-45F);
        if ((this.captionMode == 2) && (m > 0))
        {
          f = (32 - j) / 32.0F * 0.8F + 0.1F;
          i = 2;
          break;
        }
        f = i / 32.0F * 0.8F + 0.1F;
        i = 0;
        break;
        label232:
        j = this.row;
        k = 0;
      }
    }
    
    public SpannableString buildSpannableString()
    {
      int k = this.captionStringBuilder.length();
      int i = 0;
      while (i < this.preambleStyles.size())
      {
        this.captionStringBuilder.setSpan(this.preambleStyles.get(i), 0, k, 33);
        i += 1;
      }
      i = 0;
      if (i < this.midrowStyles.size())
      {
        CueStyle localCueStyle = (CueStyle)this.midrowStyles.get(i);
        if (i < this.midrowStyles.size() - localCueStyle.nextStyleIncrement) {}
        for (int j = ((CueStyle)this.midrowStyles.get(localCueStyle.nextStyleIncrement + i)).start;; j = k)
        {
          this.captionStringBuilder.setSpan(localCueStyle.style, localCueStyle.start, j, 33);
          i += 1;
          break;
        }
      }
      if (this.underlineStartPosition != -1) {
        this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, k, 33);
      }
      return new SpannableString(this.captionStringBuilder);
    }
    
    public int getRow()
    {
      return this.row;
    }
    
    public boolean isEmpty()
    {
      return (this.preambleStyles.isEmpty()) && (this.midrowStyles.isEmpty()) && (this.rolledUpCaptions.isEmpty()) && (this.captionStringBuilder.length() == 0);
    }
    
    public void reset(int paramInt)
    {
      this.captionMode = paramInt;
      this.preambleStyles.clear();
      this.midrowStyles.clear();
      this.rolledUpCaptions.clear();
      this.captionStringBuilder.clear();
      this.row = 15;
      this.indent = 0;
      this.tabOffset = 0;
      this.underlineStartPosition = -1;
    }
    
    public void rollUp()
    {
      this.rolledUpCaptions.add(buildSpannableString());
      this.captionStringBuilder.clear();
      this.preambleStyles.clear();
      this.midrowStyles.clear();
      this.underlineStartPosition = -1;
      int i = Math.min(this.captionRowCount, this.row);
      while (this.rolledUpCaptions.size() >= i) {
        this.rolledUpCaptions.remove(0);
      }
    }
    
    public void setCaptionRowCount(int paramInt)
    {
      this.captionRowCount = paramInt;
    }
    
    public void setIndent(int paramInt)
    {
      this.indent = paramInt;
    }
    
    public void setMidrowStyle(CharacterStyle paramCharacterStyle, int paramInt)
    {
      this.midrowStyles.add(new CueStyle(paramCharacterStyle, this.captionStringBuilder.length(), paramInt));
    }
    
    public void setPreambleStyle(CharacterStyle paramCharacterStyle)
    {
      this.preambleStyles.add(paramCharacterStyle);
    }
    
    public void setRow(int paramInt)
    {
      this.row = paramInt;
    }
    
    public void setTab(int paramInt)
    {
      this.tabOffset = paramInt;
    }
    
    public void setUnderline(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.underlineStartPosition = this.captionStringBuilder.length();
      }
      while (this.underlineStartPosition == -1) {
        return;
      }
      this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
      this.underlineStartPosition = -1;
    }
    
    public String toString()
    {
      return this.captionStringBuilder.toString();
    }
    
    static class CueStyle
    {
      public final int nextStyleIncrement;
      public final int start;
      public final CharacterStyle style;
      
      public CueStyle(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2)
      {
        this.style = paramCharacterStyle;
        this.start = paramInt1;
        this.nextStyleIncrement = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.Cea608Decoder
 * JD-Core Version:    0.7.0.1
 */