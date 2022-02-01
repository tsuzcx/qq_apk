package com.google.android.exoplayer2.text.cea;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class Cea708Decoder
  extends CeaDecoder
{
  private static final int CC_VALID_FLAG = 4;
  private static final int CHARACTER_BIG_CARONS = 42;
  private static final int CHARACTER_BIG_OE = 44;
  private static final int CHARACTER_BOLD_BULLET = 53;
  private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
  private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
  private static final int CHARACTER_DIAERESIS_Y = 63;
  private static final int CHARACTER_ELLIPSIS = 37;
  private static final int CHARACTER_FIVE_EIGHTHS = 120;
  private static final int CHARACTER_HORIZONTAL_BORDER = 125;
  private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
  private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
  private static final int CHARACTER_MN = 127;
  private static final int CHARACTER_NBTSP = 33;
  private static final int CHARACTER_ONE_EIGHTH = 118;
  private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
  private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
  private static final int CHARACTER_SEVEN_EIGHTHS = 121;
  private static final int CHARACTER_SM = 61;
  private static final int CHARACTER_SMALL_CARONS = 58;
  private static final int CHARACTER_SMALL_OE = 60;
  private static final int CHARACTER_SOLID_BLOCK = 48;
  private static final int CHARACTER_THREE_EIGHTHS = 119;
  private static final int CHARACTER_TM = 57;
  private static final int CHARACTER_TSP = 32;
  private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
  private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
  private static final int CHARACTER_VERTICAL_BORDER = 122;
  private static final int COMMAND_BS = 8;
  private static final int COMMAND_CLW = 136;
  private static final int COMMAND_CR = 13;
  private static final int COMMAND_CW0 = 128;
  private static final int COMMAND_CW1 = 129;
  private static final int COMMAND_CW2 = 130;
  private static final int COMMAND_CW3 = 131;
  private static final int COMMAND_CW4 = 132;
  private static final int COMMAND_CW5 = 133;
  private static final int COMMAND_CW6 = 134;
  private static final int COMMAND_CW7 = 135;
  private static final int COMMAND_DF0 = 152;
  private static final int COMMAND_DF1 = 153;
  private static final int COMMAND_DF2 = 154;
  private static final int COMMAND_DF3 = 155;
  private static final int COMMAND_DF4 = 156;
  private static final int COMMAND_DF5 = 157;
  private static final int COMMAND_DF6 = 158;
  private static final int COMMAND_DF7 = 159;
  private static final int COMMAND_DLC = 142;
  private static final int COMMAND_DLW = 140;
  private static final int COMMAND_DLY = 141;
  private static final int COMMAND_DSW = 137;
  private static final int COMMAND_ETX = 3;
  private static final int COMMAND_EXT1 = 16;
  private static final int COMMAND_EXT1_END = 23;
  private static final int COMMAND_EXT1_START = 17;
  private static final int COMMAND_FF = 12;
  private static final int COMMAND_HCR = 14;
  private static final int COMMAND_HDW = 138;
  private static final int COMMAND_NUL = 0;
  private static final int COMMAND_P16_END = 31;
  private static final int COMMAND_P16_START = 24;
  private static final int COMMAND_RST = 143;
  private static final int COMMAND_SPA = 144;
  private static final int COMMAND_SPC = 145;
  private static final int COMMAND_SPL = 146;
  private static final int COMMAND_SWA = 151;
  private static final int COMMAND_TGW = 139;
  private static final int DTVCC_PACKET_DATA = 2;
  private static final int DTVCC_PACKET_START = 3;
  private static final int GROUP_C0_END = 31;
  private static final int GROUP_C1_END = 159;
  private static final int GROUP_C2_END = 31;
  private static final int GROUP_C3_END = 159;
  private static final int GROUP_G0_END = 127;
  private static final int GROUP_G1_END = 255;
  private static final int GROUP_G2_END = 127;
  private static final int GROUP_G3_END = 255;
  private static final int NUM_WINDOWS = 8;
  private static final String TAG = "Cea708Decoder";
  private final ParsableByteArray ccData = new ParsableByteArray();
  private final CueBuilder[] cueBuilders;
  private List<Cue> cues;
  private CueBuilder currentCueBuilder;
  private DtvCcPacket currentDtvCcPacket;
  private int currentWindow;
  private List<Cue> lastCues;
  private final int selectedServiceNumber;
  private final ParsableBitArray serviceBlockPacket = new ParsableBitArray();
  
  public Cea708Decoder(int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.selectedServiceNumber = i;
    this.cueBuilders = new CueBuilder[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.cueBuilders[paramInt] = new CueBuilder();
      paramInt += 1;
    }
    this.currentCueBuilder = this.cueBuilders[0];
    resetCueBuilders();
  }
  
  private void finalizeCurrentPacket()
  {
    if (this.currentDtvCcPacket == null) {
      return;
    }
    processCurrentPacket();
    this.currentDtvCcPacket = null;
  }
  
  private List<Cue> getDisplayCues()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.cueBuilders[i].isEmpty()) && (this.cueBuilders[i].isVisible())) {
        localArrayList.add(this.cueBuilders[i].build());
      }
      i += 1;
    }
    Collections.sort(localArrayList);
    return Collections.unmodifiableList(localArrayList);
  }
  
  private void handleC0Command(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + paramInt);
        this.serviceBlockPacket.skipBits(8);
      }
      break;
    case 0: 
    case 14: 
      return;
    case 3: 
      this.cues = getDisplayCues();
      return;
    case 8: 
      this.currentCueBuilder.backspace();
      return;
    case 12: 
      resetCueBuilders();
      return;
    case 13: 
      this.currentCueBuilder.append('\n');
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + paramInt);
      this.serviceBlockPacket.skipBits(16);
      return;
    }
    Log.w("Cea708Decoder", "Invalid C0 command: " + paramInt);
  }
  
  private void handleC1Command(int paramInt)
  {
    int j = 1;
    int k = 1;
    int i = 1;
    switch (paramInt)
    {
    case 147: 
    case 148: 
    case 149: 
    case 150: 
    default: 
      Log.w("Cea708Decoder", "Invalid C1 command: " + paramInt);
    }
    label320:
    label372:
    do
    {
      for (;;)
      {
        return;
        paramInt -= 128;
        if (this.currentWindow != paramInt)
        {
          this.currentWindow = paramInt;
          this.currentCueBuilder = this.cueBuilders[paramInt];
          return;
          while (i <= 8)
          {
            if (this.serviceBlockPacket.readBit()) {
              this.cueBuilders[(8 - i)].clear();
            }
            i += 1;
          }
          continue;
          paramInt = 1;
          while (paramInt <= 8)
          {
            if (this.serviceBlockPacket.readBit()) {
              this.cueBuilders[(8 - paramInt)].setVisibility(true);
            }
            paramInt += 1;
          }
          continue;
          while (j <= 8)
          {
            if (this.serviceBlockPacket.readBit()) {
              this.cueBuilders[(8 - j)].setVisibility(false);
            }
            j += 1;
          }
          continue;
          paramInt = 1;
          CueBuilder localCueBuilder;
          if (paramInt <= 8) {
            if (this.serviceBlockPacket.readBit())
            {
              localCueBuilder = this.cueBuilders[(8 - paramInt)];
              if (localCueBuilder.isVisible()) {
                break label372;
              }
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localCueBuilder.setVisibility(bool);
            paramInt += 1;
            break label320;
            break;
          }
          while (k <= 8)
          {
            if (this.serviceBlockPacket.readBit()) {
              this.cueBuilders[(8 - k)].reset();
            }
            k += 1;
          }
        }
      }
      this.serviceBlockPacket.skipBits(8);
      return;
      resetCueBuilders();
      return;
      if (!this.currentCueBuilder.isDefined())
      {
        this.serviceBlockPacket.skipBits(16);
        return;
      }
      handleSetPenAttributes();
      return;
      if (!this.currentCueBuilder.isDefined())
      {
        this.serviceBlockPacket.skipBits(24);
        return;
      }
      handleSetPenColor();
      return;
      if (!this.currentCueBuilder.isDefined())
      {
        this.serviceBlockPacket.skipBits(16);
        return;
      }
      handleSetPenLocation();
      return;
      if (!this.currentCueBuilder.isDefined())
      {
        this.serviceBlockPacket.skipBits(32);
        return;
      }
      handleSetWindowAttributes();
      return;
      paramInt -= 152;
      handleDefineWindow(paramInt);
    } while (this.currentWindow == paramInt);
    this.currentWindow = paramInt;
    this.currentCueBuilder = this.cueBuilders[paramInt];
  }
  
  private void handleC2Command(int paramInt)
  {
    if (paramInt <= 7) {}
    do
    {
      return;
      if (paramInt <= 15)
      {
        this.serviceBlockPacket.skipBits(8);
        return;
      }
      if (paramInt <= 23)
      {
        this.serviceBlockPacket.skipBits(16);
        return;
      }
    } while (paramInt > 31);
    this.serviceBlockPacket.skipBits(24);
  }
  
  private void handleC3Command(int paramInt)
  {
    if (paramInt <= 135) {
      this.serviceBlockPacket.skipBits(32);
    }
    do
    {
      return;
      if (paramInt <= 143)
      {
        this.serviceBlockPacket.skipBits(40);
        return;
      }
    } while (paramInt > 159);
    this.serviceBlockPacket.skipBits(2);
    paramInt = this.serviceBlockPacket.readBits(6);
    this.serviceBlockPacket.skipBits(paramInt * 8);
  }
  
  private void handleDefineWindow(int paramInt)
  {
    CueBuilder localCueBuilder = this.cueBuilders[paramInt];
    this.serviceBlockPacket.skipBits(2);
    boolean bool1 = this.serviceBlockPacket.readBit();
    boolean bool2 = this.serviceBlockPacket.readBit();
    boolean bool3 = this.serviceBlockPacket.readBit();
    paramInt = this.serviceBlockPacket.readBits(3);
    boolean bool4 = this.serviceBlockPacket.readBit();
    int i = this.serviceBlockPacket.readBits(7);
    int j = this.serviceBlockPacket.readBits(8);
    int k = this.serviceBlockPacket.readBits(4);
    int m = this.serviceBlockPacket.readBits(4);
    this.serviceBlockPacket.skipBits(2);
    int n = this.serviceBlockPacket.readBits(6);
    this.serviceBlockPacket.skipBits(2);
    localCueBuilder.defineWindow(bool1, bool2, bool3, paramInt, bool4, i, j, m, n, k, this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
  }
  
  private void handleG0Character(int paramInt)
  {
    if (paramInt == 127)
    {
      this.currentCueBuilder.append('♫');
      return;
    }
    this.currentCueBuilder.append((char)(paramInt & 0xFF));
  }
  
  private void handleG1Character(int paramInt)
  {
    this.currentCueBuilder.append((char)(paramInt & 0xFF));
  }
  
  private void handleG2Character(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.w("Cea708Decoder", "Invalid G2 character: " + paramInt);
      return;
    case 32: 
      this.currentCueBuilder.append(' ');
      return;
    case 33: 
      this.currentCueBuilder.append(' ');
      return;
    case 37: 
      this.currentCueBuilder.append('…');
      return;
    case 42: 
      this.currentCueBuilder.append('Š');
      return;
    case 44: 
      this.currentCueBuilder.append('Œ');
      return;
    case 48: 
      this.currentCueBuilder.append('█');
      return;
    case 49: 
      this.currentCueBuilder.append('‘');
      return;
    case 50: 
      this.currentCueBuilder.append('’');
      return;
    case 51: 
      this.currentCueBuilder.append('“');
      return;
    case 52: 
      this.currentCueBuilder.append('”');
      return;
    case 53: 
      this.currentCueBuilder.append('•');
      return;
    case 57: 
      this.currentCueBuilder.append('™');
      return;
    case 58: 
      this.currentCueBuilder.append('š');
      return;
    case 60: 
      this.currentCueBuilder.append('œ');
      return;
    case 61: 
      this.currentCueBuilder.append('℠');
      return;
    case 63: 
      this.currentCueBuilder.append('Ÿ');
      return;
    case 118: 
      this.currentCueBuilder.append('⅛');
      return;
    case 119: 
      this.currentCueBuilder.append('⅜');
      return;
    case 120: 
      this.currentCueBuilder.append('⅝');
      return;
    case 121: 
      this.currentCueBuilder.append('⅞');
      return;
    case 122: 
      this.currentCueBuilder.append('│');
      return;
    case 123: 
      this.currentCueBuilder.append('┐');
      return;
    case 124: 
      this.currentCueBuilder.append('└');
      return;
    case 125: 
      this.currentCueBuilder.append('─');
      return;
    case 126: 
      this.currentCueBuilder.append('┘');
      return;
    }
    this.currentCueBuilder.append('┌');
  }
  
  private void handleG3Character(int paramInt)
  {
    if (paramInt == 160)
    {
      this.currentCueBuilder.append('㏄');
      return;
    }
    Log.w("Cea708Decoder", "Invalid G3 character: " + paramInt);
    this.currentCueBuilder.append('_');
  }
  
  private void handleSetPenAttributes()
  {
    int i = this.serviceBlockPacket.readBits(4);
    int j = this.serviceBlockPacket.readBits(2);
    int k = this.serviceBlockPacket.readBits(2);
    boolean bool1 = this.serviceBlockPacket.readBit();
    boolean bool2 = this.serviceBlockPacket.readBit();
    int m = this.serviceBlockPacket.readBits(3);
    int n = this.serviceBlockPacket.readBits(3);
    this.currentCueBuilder.setPenAttributes(i, j, k, bool1, bool2, m, n);
  }
  
  private void handleSetPenColor()
  {
    int i = this.serviceBlockPacket.readBits(2);
    i = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), i);
    int j = this.serviceBlockPacket.readBits(2);
    j = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), j);
    this.serviceBlockPacket.skipBits(2);
    int k = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
    this.currentCueBuilder.setPenColor(i, j, k);
  }
  
  private void handleSetPenLocation()
  {
    this.serviceBlockPacket.skipBits(4);
    int i = this.serviceBlockPacket.readBits(4);
    this.serviceBlockPacket.skipBits(2);
    int j = this.serviceBlockPacket.readBits(6);
    this.currentCueBuilder.setPenLocation(i, j);
  }
  
  private void handleSetWindowAttributes()
  {
    int i = this.serviceBlockPacket.readBits(2);
    int k = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), i);
    int j = this.serviceBlockPacket.readBits(2);
    int m = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
    i = j;
    if (this.serviceBlockPacket.readBit()) {
      i = j | 0x4;
    }
    boolean bool = this.serviceBlockPacket.readBit();
    j = this.serviceBlockPacket.readBits(2);
    int n = this.serviceBlockPacket.readBits(2);
    int i1 = this.serviceBlockPacket.readBits(2);
    this.serviceBlockPacket.skipBits(8);
    this.currentCueBuilder.setWindowAttributes(k, m, bool, i, j, n, i1);
  }
  
  private void processCurrentPacket()
  {
    if (this.currentDtvCcPacket.currentIndex != this.currentDtvCcPacket.packetSize * 2 - 1) {
      Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + (this.currentDtvCcPacket.packetSize * 2 - 1) + ", but current index is " + this.currentDtvCcPacket.currentIndex + " (sequence number " + this.currentDtvCcPacket.sequenceNumber + "); ignoring packet");
    }
    int i;
    do
    {
      int j;
      do
      {
        do
        {
          return;
          this.serviceBlockPacket.reset(this.currentDtvCcPacket.packetData, this.currentDtvCcPacket.currentIndex);
          j = this.serviceBlockPacket.readBits(3);
          int k = this.serviceBlockPacket.readBits(5);
          i = j;
          if (j == 7)
          {
            this.serviceBlockPacket.skipBits(2);
            i = j + this.serviceBlockPacket.readBits(6);
          }
          if (k != 0) {
            break;
          }
        } while (i == 0);
        Log.w("Cea708Decoder", "serviceNumber is non-zero (" + i + ") when blockSize is 0");
        return;
      } while (i != this.selectedServiceNumber);
      i = 0;
      while (this.serviceBlockPacket.bitsLeft() > 0)
      {
        j = this.serviceBlockPacket.readBits(8);
        if (j != 16)
        {
          if (j <= 31)
          {
            handleC0Command(j);
          }
          else if (j <= 127)
          {
            handleG0Character(j);
            i = 1;
          }
          else if (j <= 159)
          {
            handleC1Command(j);
            i = 1;
          }
          else if (j <= 255)
          {
            handleG1Character(j);
            i = 1;
          }
          else
          {
            Log.w("Cea708Decoder", "Invalid base command: " + j);
          }
        }
        else
        {
          j = this.serviceBlockPacket.readBits(8);
          if (j <= 31)
          {
            handleC2Command(j);
          }
          else if (j <= 127)
          {
            handleG2Character(j);
            i = 1;
          }
          else if (j <= 159)
          {
            handleC3Command(j);
          }
          else if (j <= 255)
          {
            handleG3Character(j);
            i = 1;
          }
          else
          {
            Log.w("Cea708Decoder", "Invalid extended command: " + j);
          }
        }
      }
    } while (i == 0);
    this.cues = getDisplayCues();
  }
  
  private void resetCueBuilders()
  {
    int i = 0;
    while (i < 8)
    {
      this.cueBuilders[i].reset();
      i += 1;
    }
  }
  
  protected Subtitle createSubtitle()
  {
    this.lastCues = this.cues;
    return new CeaSubtitle(this.cues);
  }
  
  protected void decode(SubtitleInputBuffer paramSubtitleInputBuffer)
  {
    this.ccData.reset(paramSubtitleInputBuffer.data.array(), paramSubtitleInputBuffer.data.limit());
    label61:
    label325:
    while (this.ccData.bytesLeft() >= 3)
    {
      int k = this.ccData.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      int i;
      int j;
      DtvCcPacket localDtvCcPacket;
      if ((k & 0x4) == 4)
      {
        k = 1;
        i = (byte)this.ccData.readUnsignedByte();
        j = (byte)this.ccData.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          continue;
        }
        if (m != 3) {
          break label215;
        }
        finalizeCurrentPacket();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.currentDtvCcPacket = new DtvCcPacket((i & 0xC0) >> 6, k);
        paramSubtitleInputBuffer = this.currentDtvCcPacket.packetData;
        localDtvCcPacket = this.currentDtvCcPacket;
        k = localDtvCcPacket.currentIndex;
        localDtvCcPacket.currentIndex = (k + 1);
        paramSubtitleInputBuffer[k] = j;
      }
      for (;;)
      {
        if (this.currentDtvCcPacket.currentIndex != this.currentDtvCcPacket.packetSize * 2 - 1) {
          break label325;
        }
        finalizeCurrentPacket();
        break;
        k = 0;
        break label61;
        label215:
        if (m == 2) {}
        for (boolean bool = true;; bool = false)
        {
          Assertions.checkArgument(bool);
          if (this.currentDtvCcPacket != null) {
            break label254;
          }
          Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
          break;
        }
        label254:
        paramSubtitleInputBuffer = this.currentDtvCcPacket.packetData;
        localDtvCcPacket = this.currentDtvCcPacket;
        k = localDtvCcPacket.currentIndex;
        localDtvCcPacket.currentIndex = (k + 1);
        paramSubtitleInputBuffer[k] = i;
        paramSubtitleInputBuffer = this.currentDtvCcPacket.packetData;
        localDtvCcPacket = this.currentDtvCcPacket;
        k = localDtvCcPacket.currentIndex;
        localDtvCcPacket.currentIndex = (k + 1);
        paramSubtitleInputBuffer[k] = j;
      }
    }
  }
  
  public void flush()
  {
    super.flush();
    this.cues = null;
    this.lastCues = null;
    this.currentWindow = 0;
    this.currentCueBuilder = this.cueBuilders[this.currentWindow];
    resetCueBuilders();
    this.currentDtvCcPacket = null;
  }
  
  public String getName()
  {
    return "Cea708Decoder";
  }
  
  protected boolean isNewSubtitleDataAvailable()
  {
    return this.cues != this.lastCues;
  }
  
  static final class CueBuilder
  {
    private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
    private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
    public static final int COLOR_SOLID_BLACK;
    public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
    public static final int COLOR_TRANSPARENT;
    private static final int DEFAULT_PRIORITY = 4;
    private static final int DIRECTION_BOTTOM_TO_TOP = 3;
    private static final int DIRECTION_LEFT_TO_RIGHT = 0;
    private static final int DIRECTION_RIGHT_TO_LEFT = 1;
    private static final int DIRECTION_TOP_TO_BOTTOM = 2;
    private static final int HORIZONTAL_SIZE = 209;
    private static final int JUSTIFICATION_CENTER = 2;
    private static final int JUSTIFICATION_FULL = 3;
    private static final int JUSTIFICATION_LEFT = 0;
    private static final int JUSTIFICATION_RIGHT = 1;
    private static final int MAXIMUM_ROW_COUNT = 15;
    private static final int PEN_FONT_STYLE_DEFAULT = 0;
    private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
    private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
    private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
    private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
    private static final int PEN_OFFSET_NORMAL = 1;
    private static final int PEN_SIZE_STANDARD = 1;
    private static final int[] PEN_STYLE_BACKGROUND = { COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_TRANSPARENT, COLOR_TRANSPARENT };
    private static final int[] PEN_STYLE_EDGE_TYPE;
    private static final int[] PEN_STYLE_FONT_STYLE;
    private static final int RELATIVE_CUE_SIZE = 99;
    private static final int VERTICAL_SIZE = 74;
    private static final int[] WINDOW_STYLE_FILL;
    private static final int[] WINDOW_STYLE_JUSTIFICATION;
    private static final int[] WINDOW_STYLE_PRINT_DIRECTION;
    private static final int[] WINDOW_STYLE_SCROLL_DIRECTION;
    private static final boolean[] WINDOW_STYLE_WORD_WRAP;
    private int anchorId;
    private int backgroundColor;
    private int backgroundColorStartPosition;
    private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();
    private boolean defined;
    private int foregroundColor;
    private int foregroundColorStartPosition;
    private int horizontalAnchor;
    private int italicsStartPosition;
    private int justification;
    private int penStyleId;
    private int priority;
    private boolean relativePositioning;
    private final List<SpannableString> rolledUpCaptions = new LinkedList();
    private int row;
    private int rowCount;
    private boolean rowLock;
    private int underlineStartPosition;
    private int verticalAnchor;
    private boolean visible;
    private int windowFillColor;
    private int windowStyleId;
    
    static
    {
      COLOR_SOLID_BLACK = getArgbColorFromCeaColor(0, 0, 0, 0);
      COLOR_TRANSPARENT = getArgbColorFromCeaColor(0, 0, 0, 3);
      WINDOW_STYLE_JUSTIFICATION = new int[] { 0, 0, 0, 0, 0, 2, 0 };
      WINDOW_STYLE_PRINT_DIRECTION = new int[] { 0, 0, 0, 0, 0, 0, 2 };
      WINDOW_STYLE_SCROLL_DIRECTION = new int[] { 3, 3, 3, 3, 3, 3, 1 };
      WINDOW_STYLE_WORD_WRAP = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
      WINDOW_STYLE_FILL = new int[] { COLOR_SOLID_BLACK, COLOR_TRANSPARENT, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_TRANSPARENT, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK };
      PEN_STYLE_FONT_STYLE = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      PEN_STYLE_EDGE_TYPE = new int[] { 0, 0, 0, 0, 0, 3, 3 };
    }
    
    public CueBuilder()
    {
      reset();
    }
    
    public static int getArgbColorFromCeaColor(int paramInt1, int paramInt2, int paramInt3)
    {
      return getArgbColorFromCeaColor(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public static int getArgbColorFromCeaColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 255;
      Assertions.checkIndex(paramInt1, 0, 4);
      Assertions.checkIndex(paramInt2, 0, 4);
      Assertions.checkIndex(paramInt3, 0, 4);
      Assertions.checkIndex(paramInt4, 0, 4);
      switch (paramInt4)
      {
      default: 
        paramInt4 = 255;
        if (paramInt1 > 1)
        {
          paramInt1 = 255;
          label77:
          if (paramInt2 <= 1) {
            break label125;
          }
          paramInt2 = 255;
          label86:
          if (paramInt3 <= 1) {
            break label130;
          }
        }
        break;
      }
      label130:
      for (paramInt3 = i;; paramInt3 = 0)
      {
        return Color.argb(paramInt4, paramInt1, paramInt2, paramInt3);
        paramInt4 = 255;
        break;
        paramInt4 = 127;
        break;
        paramInt4 = 0;
        break;
        paramInt1 = 0;
        break label77;
        label125:
        paramInt2 = 0;
        break label86;
      }
    }
    
    public void append(char paramChar)
    {
      if (paramChar == '\n')
      {
        this.rolledUpCaptions.add(buildSpannableString());
        this.captionStringBuilder.clear();
        if (this.italicsStartPosition != -1) {
          this.italicsStartPosition = 0;
        }
        if (this.underlineStartPosition != -1) {
          this.underlineStartPosition = 0;
        }
        if (this.foregroundColorStartPosition != -1) {
          this.foregroundColorStartPosition = 0;
        }
        if (this.backgroundColorStartPosition != -1) {
          this.backgroundColorStartPosition = 0;
        }
        while (((this.rowLock) && (this.rolledUpCaptions.size() >= this.rowCount)) || (this.rolledUpCaptions.size() >= 15)) {
          this.rolledUpCaptions.remove(0);
        }
      }
      this.captionStringBuilder.append(paramChar);
    }
    
    public void backspace()
    {
      int i = this.captionStringBuilder.length();
      if (i > 0) {
        this.captionStringBuilder.delete(i - 1, i);
      }
    }
    
    public Cea708Cue build()
    {
      if (isEmpty()) {
        return null;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int i = 0;
      while (i < this.rolledUpCaptions.size())
      {
        localSpannableStringBuilder.append((CharSequence)this.rolledUpCaptions.get(i));
        localSpannableStringBuilder.append('\n');
        i += 1;
      }
      localSpannableStringBuilder.append(buildSpannableString());
      Layout.Alignment localAlignment;
      float f2;
      float f1;
      label172:
      label183:
      int j;
      switch (this.justification)
      {
      default: 
        throw new IllegalArgumentException("Unexpected justification value: " + this.justification);
      case 0: 
      case 3: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if (this.relativePositioning)
        {
          f2 = this.horizontalAnchor / 99.0F;
          f1 = this.verticalAnchor / 99.0F;
          if (this.anchorId % 3 != 0) {
            break label287;
          }
          i = 0;
          if (this.anchorId / 3 != 0) {
            break label307;
          }
          j = 0;
          label195:
          if (this.windowFillColor == COLOR_SOLID_BLACK) {
            break label329;
          }
        }
        break;
      }
      label287:
      label307:
      label329:
      for (boolean bool = true;; bool = false)
      {
        return new Cea708Cue(localSpannableStringBuilder, localAlignment, f1 * 0.9F + 0.05F, 0, i, f2 * 0.9F + 0.05F, j, 1.4E-45F, bool, this.windowFillColor, this.priority);
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        f2 = this.horizontalAnchor / 209.0F;
        f1 = this.verticalAnchor / 74.0F;
        break label172;
        if (this.anchorId % 3 == 1)
        {
          i = 1;
          break label183;
        }
        i = 2;
        break label183;
        if (this.anchorId / 3 == 1)
        {
          j = 1;
          break label195;
        }
        j = 2;
        break label195;
      }
    }
    
    public SpannableString buildSpannableString()
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
      int i = localSpannableStringBuilder.length();
      if (i > 0)
      {
        if (this.italicsStartPosition != -1) {
          localSpannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, i, 33);
        }
        if (this.underlineStartPosition != -1) {
          localSpannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, i, 33);
        }
        if (this.foregroundColorStartPosition != -1) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, i, 33);
        }
        if (this.backgroundColorStartPosition != -1) {
          localSpannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, i, 33);
        }
      }
      return new SpannableString(localSpannableStringBuilder);
    }
    
    public void clear()
    {
      this.rolledUpCaptions.clear();
      this.captionStringBuilder.clear();
      this.italicsStartPosition = -1;
      this.underlineStartPosition = -1;
      this.foregroundColorStartPosition = -1;
      this.backgroundColorStartPosition = -1;
      this.row = 0;
    }
    
    public void defineWindow(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, boolean paramBoolean4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      this.defined = true;
      this.visible = paramBoolean1;
      this.rowLock = paramBoolean2;
      this.priority = paramInt1;
      this.relativePositioning = paramBoolean4;
      this.verticalAnchor = paramInt2;
      this.horizontalAnchor = paramInt3;
      this.anchorId = paramInt6;
      if (this.rowCount != paramInt4 + 1)
      {
        this.rowCount = (paramInt4 + 1);
        while (((paramBoolean2) && (this.rolledUpCaptions.size() >= this.rowCount)) || (this.rolledUpCaptions.size() >= 15)) {
          this.rolledUpCaptions.remove(0);
        }
      }
      if ((paramInt7 != 0) && (this.windowStyleId != paramInt7))
      {
        this.windowStyleId = paramInt7;
        paramInt1 = paramInt7 - 1;
        setWindowAttributes(WINDOW_STYLE_FILL[paramInt1], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[paramInt1], 0, WINDOW_STYLE_PRINT_DIRECTION[paramInt1], WINDOW_STYLE_SCROLL_DIRECTION[paramInt1], WINDOW_STYLE_JUSTIFICATION[paramInt1]);
      }
      if ((paramInt8 != 0) && (this.penStyleId != paramInt8))
      {
        this.penStyleId = paramInt8;
        paramInt1 = paramInt8 - 1;
        setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[paramInt1], PEN_STYLE_FONT_STYLE[paramInt1]);
        setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[paramInt1], COLOR_SOLID_BLACK);
      }
    }
    
    public boolean isDefined()
    {
      return this.defined;
    }
    
    public boolean isEmpty()
    {
      return (!isDefined()) || ((this.rolledUpCaptions.isEmpty()) && (this.captionStringBuilder.length() == 0));
    }
    
    public boolean isVisible()
    {
      return this.visible;
    }
    
    public void reset()
    {
      clear();
      this.defined = false;
      this.visible = false;
      this.priority = 4;
      this.relativePositioning = false;
      this.verticalAnchor = 0;
      this.horizontalAnchor = 0;
      this.anchorId = 0;
      this.rowCount = 15;
      this.rowLock = true;
      this.justification = 0;
      this.windowStyleId = 0;
      this.penStyleId = 0;
      this.windowFillColor = COLOR_SOLID_BLACK;
      this.foregroundColor = COLOR_SOLID_WHITE;
      this.backgroundColor = COLOR_SOLID_BLACK;
    }
    
    public void setPenAttributes(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5)
    {
      if (this.italicsStartPosition != -1) {
        if (!paramBoolean1)
        {
          this.captionStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
          this.italicsStartPosition = -1;
        }
      }
      do
      {
        while (this.underlineStartPosition != -1)
        {
          if (!paramBoolean2)
          {
            this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
            this.underlineStartPosition = -1;
          }
          return;
          if (paramBoolean1) {
            this.italicsStartPosition = this.captionStringBuilder.length();
          }
        }
      } while (!paramBoolean2);
      this.underlineStartPosition = this.captionStringBuilder.length();
    }
    
    public void setPenColor(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((this.foregroundColorStartPosition != -1) && (this.foregroundColor != paramInt1)) {
        this.captionStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
      }
      if (paramInt1 != COLOR_SOLID_WHITE)
      {
        this.foregroundColorStartPosition = this.captionStringBuilder.length();
        this.foregroundColor = paramInt1;
      }
      if ((this.backgroundColorStartPosition != -1) && (this.backgroundColor != paramInt2)) {
        this.captionStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
      }
      if (paramInt2 != COLOR_SOLID_BLACK)
      {
        this.backgroundColorStartPosition = this.captionStringBuilder.length();
        this.backgroundColor = paramInt2;
      }
    }
    
    public void setPenLocation(int paramInt1, int paramInt2)
    {
      if (this.row != paramInt1) {
        append('\n');
      }
      this.row = paramInt1;
    }
    
    public void setVisibility(boolean paramBoolean)
    {
      this.visible = paramBoolean;
    }
    
    public void setWindowAttributes(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.windowFillColor = paramInt1;
      this.justification = paramInt6;
    }
  }
  
  static final class DtvCcPacket
  {
    int currentIndex;
    public final byte[] packetData;
    public final int packetSize;
    public final int sequenceNumber;
    
    public DtvCcPacket(int paramInt1, int paramInt2)
    {
      this.sequenceNumber = paramInt1;
      this.packetSize = paramInt2;
      this.packetData = new byte[paramInt2 * 2 - 1];
      this.currentIndex = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.Cea708Decoder
 * JD-Core Version:    0.7.0.1
 */