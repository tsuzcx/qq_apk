package org.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.extensions.DefaultExtension;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Draft_6455
  extends Draft
{
  private static final String CONNECTION = "Connection";
  private static final String SEC_WEB_SOCKET_ACCEPT = "Sec-WebSocket-Accept";
  private static final String SEC_WEB_SOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
  private static final String SEC_WEB_SOCKET_KEY = "Sec-WebSocket-Key";
  private static final String SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
  private static final String UPGRADE = "Upgrade";
  private static final Logger log;
  private final List<ByteBuffer> byteBufferList;
  private Framedata currentContinuousFrame;
  private IExtension extension = new DefaultExtension();
  private ByteBuffer incompleteframe;
  private List<IExtension> knownExtensions;
  private List<IProtocol> knownProtocols;
  private int maxFrameSize;
  private IProtocol protocol;
  private final Random reuseableRandom = new Random();
  
  static
  {
    if (!Draft_6455.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      log = LoggerFactory.getLogger(Draft_6455.class);
      return;
    }
  }
  
  public Draft_6455()
  {
    this(Collections.emptyList());
  }
  
  public Draft_6455(List<IExtension> paramList)
  {
    this(paramList, Collections.singletonList(new Protocol("")));
  }
  
  public Draft_6455(List<IExtension> paramList, int paramInt)
  {
    this(paramList, Collections.singletonList(new Protocol("")), paramInt);
  }
  
  public Draft_6455(List<IExtension> paramList, List<IProtocol> paramList1)
  {
    this(paramList, paramList1, 2147483647);
  }
  
  public Draft_6455(List<IExtension> paramList, List<IProtocol> paramList1, int paramInt)
  {
    if ((paramList == null) || (paramList1 == null) || (paramInt < 1)) {
      throw new IllegalArgumentException();
    }
    this.knownExtensions = new ArrayList(paramList.size());
    this.knownProtocols = new ArrayList(paramList1.size());
    this.byteBufferList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((IExtension)localIterator.next()).getClass().equals(DefaultExtension.class)) {
        break label195;
      }
      i = 1;
    }
    label195:
    for (;;)
    {
      break;
      this.knownExtensions.addAll(paramList);
      if (i == 0) {
        this.knownExtensions.add(this.knownExtensions.size(), this.extension);
      }
      this.knownProtocols.addAll(paramList1);
      this.maxFrameSize = paramInt;
      return;
    }
  }
  
  public Draft_6455(IExtension paramIExtension)
  {
    this(Collections.singletonList(paramIExtension));
  }
  
  private void addToBufferList(ByteBuffer paramByteBuffer)
  {
    synchronized (this.byteBufferList)
    {
      this.byteBufferList.add(paramByteBuffer);
      return;
    }
  }
  
  private void checkBufferLimit()
    throws LimitExceededException
  {
    long l = getByteBufferListSize();
    if (l > this.maxFrameSize)
    {
      clearBufferList();
      log.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.maxFrameSize), Long.valueOf(l));
      throw new LimitExceededException(this.maxFrameSize);
    }
  }
  
  private void clearBufferList()
  {
    synchronized (this.byteBufferList)
    {
      this.byteBufferList.clear();
      return;
    }
  }
  
  private HandshakeState containsRequestedProtocol(String paramString)
  {
    Iterator localIterator = this.knownProtocols.iterator();
    while (localIterator.hasNext())
    {
      IProtocol localIProtocol = (IProtocol)localIterator.next();
      if (localIProtocol.acceptProvidedProtocol(paramString))
      {
        this.protocol = localIProtocol;
        log.trace("acceptHandshake - Matching protocol found: {}", this.protocol);
        return HandshakeState.MATCHED;
      }
    }
    return HandshakeState.NOT_MATCHED;
  }
  
  private ByteBuffer createByteBufferFromFramedata(Framedata paramFramedata)
  {
    int k = 0;
    ByteBuffer localByteBuffer1 = paramFramedata.getPayloadData();
    boolean bool;
    int m;
    label43:
    int j;
    label50:
    ByteBuffer localByteBuffer2;
    if (this.role == Role.CLIENT)
    {
      bool = true;
      m = getSizeBytes(localByteBuffer1);
      if (m <= 1) {
        break label140;
      }
      i = m + 1;
      if (!bool) {
        break label146;
      }
      j = 4;
      localByteBuffer2 = ByteBuffer.allocate(j + (i + 1) + localByteBuffer1.remaining());
      j = fromOpcode(paramFramedata.getOpcode());
      if (!paramFramedata.isFin()) {
        break label151;
      }
    }
    label140:
    label146:
    label151:
    for (int i = -128;; i = 0)
    {
      localByteBuffer2.put((byte)((byte)i | j));
      paramFramedata = toByteArray(localByteBuffer1.remaining(), m);
      if (($assertionsDisabled) || (paramFramedata.length == m)) {
        break label156;
      }
      throw new AssertionError();
      bool = false;
      break;
      i = m;
      break label43;
      j = 0;
      break label50;
    }
    label156:
    if (m == 1) {
      localByteBuffer2.put((byte)(paramFramedata[0] | getMaskByte(bool)));
    }
    while (bool)
    {
      paramFramedata = ByteBuffer.allocate(4);
      paramFramedata.putInt(this.reuseableRandom.nextInt());
      localByteBuffer2.put(paramFramedata.array());
      i = k;
      while (localByteBuffer1.hasRemaining())
      {
        localByteBuffer2.put((byte)(localByteBuffer1.get() ^ paramFramedata.get(i % 4)));
        i += 1;
      }
      if (m == 2)
      {
        localByteBuffer2.put((byte)(getMaskByte(bool) | 0x7E));
        localByteBuffer2.put(paramFramedata);
      }
      else if (m == 8)
      {
        localByteBuffer2.put((byte)(getMaskByte(bool) | 0x7F));
        localByteBuffer2.put(paramFramedata);
      }
      else
      {
        throw new IllegalStateException("Size representation not supported/specified");
      }
    }
    localByteBuffer2.put(localByteBuffer1);
    localByteBuffer1.flip();
    assert (localByteBuffer2.remaining() == 0) : localByteBuffer2.remaining();
    localByteBuffer2.flip();
    return localByteBuffer2;
  }
  
  private byte fromOpcode(Opcode paramOpcode)
  {
    if (paramOpcode == Opcode.CONTINUOUS) {
      return 0;
    }
    if (paramOpcode == Opcode.TEXT) {
      return 1;
    }
    if (paramOpcode == Opcode.BINARY) {
      return 2;
    }
    if (paramOpcode == Opcode.CLOSING) {
      return 8;
    }
    if (paramOpcode == Opcode.PING) {
      return 9;
    }
    if (paramOpcode == Opcode.PONG) {
      return 10;
    }
    throw new IllegalArgumentException("Don't know how to handle " + paramOpcode.toString());
  }
  
  private String generateFinalKey(String paramString)
  {
    paramString = paramString.trim();
    paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      return Base64.encodeBytes(localMessageDigest.digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  private long getByteBufferListSize()
  {
    synchronized (this.byteBufferList)
    {
      Iterator localIterator = this.byteBufferList.iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((ByteBuffer)localIterator.next()).limit() + l) {}
      return l;
    }
  }
  
  private byte getMaskByte(boolean paramBoolean)
  {
    if (paramBoolean) {
      return -128;
    }
    return 0;
  }
  
  private ByteBuffer getPayloadFromByteBufferList()
    throws LimitExceededException
  {
    synchronized (this.byteBufferList)
    {
      Object localObject = this.byteBufferList.iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = ((ByteBuffer)((Iterator)localObject).next()).limit() + l) {}
      checkBufferLimit();
      localObject = ByteBuffer.allocate((int)l);
      Iterator localIterator = this.byteBufferList.iterator();
      if (localIterator.hasNext()) {
        ((ByteBuffer)localObject).put((ByteBuffer)localIterator.next());
      }
    }
    localByteBuffer.flip();
    return localByteBuffer;
  }
  
  private String getServerTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  private int getSizeBytes(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.remaining() <= 125) {
      return 1;
    }
    if (paramByteBuffer.remaining() <= 65535) {
      return 2;
    }
    return 8;
  }
  
  private void logRuntimeException(WebSocketImpl paramWebSocketImpl, RuntimeException paramRuntimeException)
  {
    log.error("Runtime exception during onWebsocketMessage", paramRuntimeException);
    paramWebSocketImpl.getWebSocketListener().onWebsocketError(paramWebSocketImpl, paramRuntimeException);
  }
  
  private void processFrameBinary(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
  {
    try
    {
      paramWebSocketImpl.getWebSocketListener().onWebsocketMessage(paramWebSocketImpl, paramFramedata.getPayloadData());
      return;
    }
    catch (RuntimeException paramFramedata)
    {
      logRuntimeException(paramWebSocketImpl, paramFramedata);
    }
  }
  
  private void processFrameClosing(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
  {
    int i = 1005;
    String str = "";
    if ((paramFramedata instanceof CloseFrame))
    {
      paramFramedata = (CloseFrame)paramFramedata;
      i = paramFramedata.getCloseCode();
      str = paramFramedata.getMessage();
    }
    if (paramWebSocketImpl.getReadyState() == ReadyState.CLOSING)
    {
      paramWebSocketImpl.closeConnection(i, str, true);
      return;
    }
    if (getCloseHandshakeType() == CloseHandshakeType.TWOWAY)
    {
      paramWebSocketImpl.close(i, str, true);
      return;
    }
    paramWebSocketImpl.flushAndClose(i, str, false);
  }
  
  private void processFrameContinuousAndNonFin(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata, Opcode paramOpcode)
    throws InvalidDataException
  {
    if (paramOpcode != Opcode.CONTINUOUS) {
      processFrameIsNotFin(paramFramedata);
    }
    while ((paramOpcode == Opcode.TEXT) && (!Charsetfunctions.isValidUTF8(paramFramedata.getPayloadData())))
    {
      log.error("Protocol error: Payload is not UTF8");
      throw new InvalidDataException(1007);
      if (paramFramedata.isFin())
      {
        processFrameIsFin(paramWebSocketImpl, paramFramedata);
      }
      else if (this.currentContinuousFrame == null)
      {
        log.error("Protocol error: Continuous frame sequence was not started.");
        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
      }
    }
    if ((paramOpcode == Opcode.CONTINUOUS) && (this.currentContinuousFrame != null)) {
      addToBufferList(paramFramedata.getPayloadData());
    }
  }
  
  private void processFrameIsFin(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
    throws InvalidDataException
  {
    if (this.currentContinuousFrame == null)
    {
      log.trace("Protocol error: Previous continuous frame sequence not completed.");
      throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
    }
    addToBufferList(paramFramedata.getPayloadData());
    checkBufferLimit();
    if (this.currentContinuousFrame.getOpcode() == Opcode.TEXT)
    {
      ((FramedataImpl1)this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
      ((FramedataImpl1)this.currentContinuousFrame).isValid();
    }
    for (;;)
    {
      try
      {
        paramWebSocketImpl.getWebSocketListener().onWebsocketMessage(paramWebSocketImpl, Charsetfunctions.stringUtf8(this.currentContinuousFrame.getPayloadData()));
        this.currentContinuousFrame = null;
        clearBufferList();
        return;
      }
      catch (RuntimeException paramFramedata)
      {
        logRuntimeException(paramWebSocketImpl, paramFramedata);
        continue;
      }
      if (this.currentContinuousFrame.getOpcode() == Opcode.BINARY)
      {
        ((FramedataImpl1)this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
        ((FramedataImpl1)this.currentContinuousFrame).isValid();
        try
        {
          paramWebSocketImpl.getWebSocketListener().onWebsocketMessage(paramWebSocketImpl, this.currentContinuousFrame.getPayloadData());
        }
        catch (RuntimeException paramFramedata)
        {
          logRuntimeException(paramWebSocketImpl, paramFramedata);
        }
      }
    }
  }
  
  private void processFrameIsNotFin(Framedata paramFramedata)
    throws InvalidDataException
  {
    if (this.currentContinuousFrame != null)
    {
      log.trace("Protocol error: Previous continuous frame sequence not completed.");
      throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
    }
    this.currentContinuousFrame = paramFramedata;
    addToBufferList(paramFramedata.getPayloadData());
    checkBufferLimit();
  }
  
  private void processFrameText(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
    throws InvalidDataException
  {
    try
    {
      paramWebSocketImpl.getWebSocketListener().onWebsocketMessage(paramWebSocketImpl, Charsetfunctions.stringUtf8(paramFramedata.getPayloadData()));
      return;
    }
    catch (RuntimeException paramFramedata)
    {
      logRuntimeException(paramWebSocketImpl, paramFramedata);
    }
  }
  
  private byte[] toByteArray(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >>> paramInt * 8 - 8 - i * 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private Opcode toOpcode(byte paramByte)
    throws InvalidFrameException
  {
    switch (paramByte)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new InvalidFrameException("Unknown opcode " + (short)paramByte);
    case 0: 
      return Opcode.CONTINUOUS;
    case 1: 
      return Opcode.TEXT;
    case 2: 
      return Opcode.BINARY;
    case 8: 
      return Opcode.CLOSING;
    case 9: 
      return Opcode.PING;
    }
    return Opcode.PONG;
  }
  
  private Framedata translateSingleFrame(ByteBuffer paramByteBuffer)
    throws IncompleteException, InvalidDataException
  {
    int n = 0;
    if (paramByteBuffer == null) {
      throw new IllegalArgumentException();
    }
    int i1 = paramByteBuffer.remaining();
    int k = 2;
    translateSingleFrameCheckPacketSize(i1, 2);
    int j = paramByteBuffer.get();
    boolean bool1;
    boolean bool2;
    label56:
    boolean bool3;
    label66:
    boolean bool4;
    label76:
    int i;
    label92:
    Object localObject2;
    if (j >> 8 != 0)
    {
      bool1 = true;
      if ((j & 0x40) == 0) {
        break label244;
      }
      bool2 = true;
      if ((j & 0x20) == 0) {
        break label250;
      }
      bool3 = true;
      if ((j & 0x10) == 0) {
        break label256;
      }
      bool4 = true;
      m = paramByteBuffer.get();
      if ((m & 0xFFFFFF80) == 0) {
        break label262;
      }
      i = 1;
      m = (byte)(m & 0x7F);
      localObject1 = toOpcode((byte)(j & 0xF));
      if (m >= 0)
      {
        j = m;
        if (m <= 125) {}
      }
      else
      {
        localObject2 = translateSingleFramePayloadLength(paramByteBuffer, (Opcode)localObject1, m, i1, 2);
        j = ((TranslatedPayloadMetaData)localObject2).getPayloadLength();
        k = ((TranslatedPayloadMetaData)localObject2).getRealPackageSize();
      }
      translateSingleFrameCheckLengthLimit(j);
      if (i == 0) {
        break label267;
      }
    }
    label256:
    label262:
    label267:
    for (int m = 4;; m = 0)
    {
      translateSingleFrameCheckPacketSize(i1, m + k + j);
      localObject2 = ByteBuffer.allocate(checkAlloc(j));
      if (i == 0) {
        break label273;
      }
      byte[] arrayOfByte = new byte[4];
      paramByteBuffer.get(arrayOfByte);
      i = n;
      while (i < j)
      {
        ((ByteBuffer)localObject2).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(i % 4)]));
        i += 1;
      }
      bool1 = false;
      break;
      label244:
      bool2 = false;
      break label56;
      label250:
      bool3 = false;
      break label66;
      bool4 = false;
      break label76;
      i = 0;
      break label92;
    }
    label273:
    ((ByteBuffer)localObject2).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject2).limit());
    paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject2).limit());
    Object localObject1 = FramedataImpl1.get((Opcode)localObject1);
    ((FramedataImpl1)localObject1).setFin(bool1);
    ((FramedataImpl1)localObject1).setRSV1(bool2);
    ((FramedataImpl1)localObject1).setRSV2(bool3);
    ((FramedataImpl1)localObject1).setRSV3(bool4);
    ((ByteBuffer)localObject2).flip();
    ((FramedataImpl1)localObject1).setPayload((ByteBuffer)localObject2);
    getExtension().isFrameValid((Framedata)localObject1);
    getExtension().decodeFrame((Framedata)localObject1);
    if (log.isTraceEnabled())
    {
      localObject2 = log;
      i = ((FramedataImpl1)localObject1).getPayloadData().remaining();
      if (((FramedataImpl1)localObject1).getPayloadData().remaining() <= 1000) {
        break label443;
      }
    }
    label443:
    for (paramByteBuffer = "too big to display";; paramByteBuffer = new String(((FramedataImpl1)localObject1).getPayloadData().array()))
    {
      ((Logger)localObject2).trace("afterDecoding({}): {}", Integer.valueOf(i), paramByteBuffer);
      ((FramedataImpl1)localObject1).isValid();
      return localObject1;
    }
  }
  
  private void translateSingleFrameCheckLengthLimit(long paramLong)
    throws LimitExceededException
  {
    if (paramLong > 2147483647L)
    {
      log.trace("Limit exedeed: Payloadsize is to big...");
      throw new LimitExceededException("Payloadsize is to big...");
    }
    if (paramLong > this.maxFrameSize)
    {
      log.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.maxFrameSize), Long.valueOf(paramLong));
      throw new LimitExceededException("Payload limit reached.", this.maxFrameSize);
    }
    if (paramLong < 0L)
    {
      log.trace("Limit underflow: Payloadsize is to little...");
      throw new LimitExceededException("Payloadsize is to little...");
    }
  }
  
  private void translateSingleFrameCheckPacketSize(int paramInt1, int paramInt2)
    throws IncompleteException
  {
    if (paramInt1 < paramInt2)
    {
      log.trace("Incomplete frame: maxpacketsize < realpacketsize");
      throw new IncompleteException(paramInt2);
    }
  }
  
  private TranslatedPayloadMetaData translateSingleFramePayloadLength(ByteBuffer paramByteBuffer, Opcode paramOpcode, int paramInt1, int paramInt2, int paramInt3)
    throws InvalidFrameException, IncompleteException, LimitExceededException
  {
    if ((paramOpcode == Opcode.PING) || (paramOpcode == Opcode.PONG) || (paramOpcode == Opcode.CLOSING))
    {
      log.trace("Invalid frame: more than 125 octets");
      throw new InvalidFrameException("more than 125 octets");
    }
    if (paramInt1 == 126)
    {
      paramInt1 = paramInt3 + 2;
      translateSingleFrameCheckPacketSize(paramInt2, paramInt1);
      paramOpcode = new byte[3];
      paramOpcode[1] = paramByteBuffer.get();
      paramOpcode[2] = paramByteBuffer.get();
      paramInt2 = new BigInteger(paramOpcode).intValue();
    }
    for (;;)
    {
      return new TranslatedPayloadMetaData(paramInt2, paramInt1);
      paramInt3 += 8;
      translateSingleFrameCheckPacketSize(paramInt2, paramInt3);
      paramOpcode = new byte[8];
      paramInt1 = 0;
      while (paramInt1 < 8)
      {
        paramOpcode[paramInt1] = paramByteBuffer.get();
        paramInt1 += 1;
      }
      long l = new BigInteger(paramOpcode).longValue();
      translateSingleFrameCheckLengthLimit(l);
      paramInt2 = (int)l;
      paramInt1 = paramInt3;
    }
  }
  
  public HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
    throws InvalidHandshakeException
  {
    if (!basicAccept(paramServerHandshake))
    {
      log.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
      return HandshakeState.NOT_MATCHED;
    }
    if ((!paramClientHandshake.hasFieldValue("Sec-WebSocket-Key")) || (!paramServerHandshake.hasFieldValue("Sec-WebSocket-Accept")))
    {
      log.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
      return HandshakeState.NOT_MATCHED;
    }
    String str = paramServerHandshake.getFieldValue("Sec-WebSocket-Accept");
    if (!generateFinalKey(paramClientHandshake.getFieldValue("Sec-WebSocket-Key")).equals(str))
    {
      log.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
      return HandshakeState.NOT_MATCHED;
    }
    paramClientHandshake = HandshakeState.NOT_MATCHED;
    str = paramServerHandshake.getFieldValue("Sec-WebSocket-Extensions");
    Iterator localIterator = this.knownExtensions.iterator();
    while (localIterator.hasNext())
    {
      IExtension localIExtension = (IExtension)localIterator.next();
      if (localIExtension.acceptProvidedExtensionAsClient(str))
      {
        this.extension = localIExtension;
        paramClientHandshake = HandshakeState.MATCHED;
        log.trace("acceptHandshakeAsClient - Matching extension found: {}", this.extension);
      }
    }
    for (;;)
    {
      if ((containsRequestedProtocol(paramServerHandshake.getFieldValue("Sec-WebSocket-Protocol")) == HandshakeState.MATCHED) && (paramClientHandshake == HandshakeState.MATCHED)) {
        return HandshakeState.MATCHED;
      }
      log.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
      return HandshakeState.NOT_MATCHED;
    }
  }
  
  public HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
    throws InvalidHandshakeException
  {
    if (readVersion(paramClientHandshake) != 13)
    {
      log.trace("acceptHandshakeAsServer - Wrong websocket version.");
      return HandshakeState.NOT_MATCHED;
    }
    HandshakeState localHandshakeState = HandshakeState.NOT_MATCHED;
    String str = paramClientHandshake.getFieldValue("Sec-WebSocket-Extensions");
    Iterator localIterator = this.knownExtensions.iterator();
    while (localIterator.hasNext())
    {
      IExtension localIExtension = (IExtension)localIterator.next();
      if (localIExtension.acceptProvidedExtensionAsServer(str))
      {
        this.extension = localIExtension;
        localHandshakeState = HandshakeState.MATCHED;
        log.trace("acceptHandshakeAsServer - Matching extension found: {}", this.extension);
      }
    }
    for (;;)
    {
      if ((containsRequestedProtocol(paramClientHandshake.getFieldValue("Sec-WebSocket-Protocol")) == HandshakeState.MATCHED) && (localHandshakeState == HandshakeState.MATCHED)) {
        return HandshakeState.MATCHED;
      }
      log.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
      return HandshakeState.NOT_MATCHED;
    }
  }
  
  public Draft copyInstance()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getKnownExtensions().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((IExtension)((Iterator)localObject).next()).copyInstance());
    }
    localObject = new ArrayList();
    Iterator localIterator = getKnownProtocols().iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject).add(((IProtocol)localIterator.next()).copyInstance());
    }
    return new Draft_6455(localArrayList, (List)localObject, this.maxFrameSize);
  }
  
  public ByteBuffer createBinaryFrame(Framedata paramFramedata)
  {
    getExtension().encodeFrame(paramFramedata);
    Logger localLogger;
    int i;
    if (log.isTraceEnabled())
    {
      localLogger = log;
      i = paramFramedata.getPayloadData().remaining();
      if (paramFramedata.getPayloadData().remaining() <= 1000) {
        break label76;
      }
    }
    label76:
    for (String str = "too big to display";; str = new String(paramFramedata.getPayloadData().array()))
    {
      localLogger.trace("afterEnconding({}): {}", Integer.valueOf(i), str);
      return createByteBufferFromFramedata(paramFramedata);
    }
  }
  
  public List<Framedata> createFrames(String paramString, boolean paramBoolean)
  {
    TextFrame localTextFrame = new TextFrame();
    localTextFrame.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(paramString)));
    localTextFrame.setTransferemasked(paramBoolean);
    try
    {
      localTextFrame.isValid();
      return Collections.singletonList(localTextFrame);
    }
    catch (InvalidDataException paramString)
    {
      throw new NotSendableException(paramString);
    }
  }
  
  public List<Framedata> createFrames(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    BinaryFrame localBinaryFrame = new BinaryFrame();
    localBinaryFrame.setPayload(paramByteBuffer);
    localBinaryFrame.setTransferemasked(paramBoolean);
    try
    {
      localBinaryFrame.isValid();
      return Collections.singletonList(localBinaryFrame);
    }
    catch (InvalidDataException paramByteBuffer)
    {
      throw new NotSendableException(paramByteBuffer);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool3;
          } while (paramObject == null);
          bool1 = bool3;
        } while (getClass() != paramObject.getClass());
        paramObject = (Draft_6455)paramObject;
        bool1 = bool3;
      } while (this.maxFrameSize != paramObject.getMaxFrameSize());
      if (this.extension == null) {
        break;
      }
      bool1 = bool3;
    } while (!this.extension.equals(paramObject.getExtension()));
    if (this.protocol != null) {
      bool1 = this.protocol.equals(paramObject.getProtocol());
    }
    for (;;)
    {
      return bool1;
      if (paramObject.getExtension() == null) {
        break;
      }
      return false;
      bool1 = bool2;
      if (paramObject.getProtocol() != null) {
        bool1 = false;
      }
    }
  }
  
  public CloseHandshakeType getCloseHandshakeType()
  {
    return CloseHandshakeType.TWOWAY;
  }
  
  public IExtension getExtension()
  {
    return this.extension;
  }
  
  public List<IExtension> getKnownExtensions()
  {
    return this.knownExtensions;
  }
  
  public List<IProtocol> getKnownProtocols()
  {
    return this.knownProtocols;
  }
  
  public int getMaxFrameSize()
  {
    return this.maxFrameSize;
  }
  
  public IProtocol getProtocol()
  {
    return this.protocol;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.extension != null) {}
    for (int i = this.extension.hashCode();; i = 0)
    {
      if (this.protocol != null) {
        j = this.protocol.hashCode();
      }
      return (i * 31 + j) * 31 + (this.maxFrameSize ^ this.maxFrameSize >>> 32);
    }
  }
  
  public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
  {
    paramClientHandshakeBuilder.put("Upgrade", "websocket");
    paramClientHandshakeBuilder.put("Connection", "Upgrade");
    Object localObject1 = new byte[16];
    this.reuseableRandom.nextBytes((byte[])localObject1);
    paramClientHandshakeBuilder.put("Sec-WebSocket-Key", Base64.encodeBytes((byte[])localObject1));
    paramClientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
    localObject1 = new StringBuilder();
    Iterator localIterator = this.knownExtensions.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (IExtension)localIterator.next();
      if ((((IExtension)localObject2).getProvidedExtensionAsClient() != null) && (((IExtension)localObject2).getProvidedExtensionAsClient().length() != 0))
      {
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append(", ");
        }
        ((StringBuilder)localObject1).append(((IExtension)localObject2).getProvidedExtensionAsClient());
      }
    }
    if (((StringBuilder)localObject1).length() != 0) {
      paramClientHandshakeBuilder.put("Sec-WebSocket-Extensions", ((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    localIterator = this.knownProtocols.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (IProtocol)localIterator.next();
      if (((IProtocol)localObject2).getProvidedProtocol().length() != 0)
      {
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append(", ");
        }
        ((StringBuilder)localObject1).append(((IProtocol)localObject2).getProvidedProtocol());
      }
    }
    if (((StringBuilder)localObject1).length() != 0) {
      paramClientHandshakeBuilder.put("Sec-WebSocket-Protocol", ((StringBuilder)localObject1).toString());
    }
    return paramClientHandshakeBuilder;
  }
  
  public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder)
    throws InvalidHandshakeException
  {
    paramServerHandshakeBuilder.put("Upgrade", "websocket");
    paramServerHandshakeBuilder.put("Connection", paramClientHandshake.getFieldValue("Connection"));
    paramClientHandshake = paramClientHandshake.getFieldValue("Sec-WebSocket-Key");
    if (paramClientHandshake == null) {
      throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }
    paramServerHandshakeBuilder.put("Sec-WebSocket-Accept", generateFinalKey(paramClientHandshake));
    if (getExtension().getProvidedExtensionAsServer().length() != 0) {
      paramServerHandshakeBuilder.put("Sec-WebSocket-Extensions", getExtension().getProvidedExtensionAsServer());
    }
    if ((getProtocol() != null) && (getProtocol().getProvidedProtocol().length() != 0)) {
      paramServerHandshakeBuilder.put("Sec-WebSocket-Protocol", getProtocol().getProvidedProtocol());
    }
    paramServerHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
    paramServerHandshakeBuilder.put("Server", "TooTallNate Java-WebSocket");
    paramServerHandshakeBuilder.put("Date", getServerTime());
    return paramServerHandshakeBuilder;
  }
  
  public void processFrame(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
    throws InvalidDataException
  {
    Opcode localOpcode = paramFramedata.getOpcode();
    if (localOpcode == Opcode.CLOSING)
    {
      processFrameClosing(paramWebSocketImpl, paramFramedata);
      return;
    }
    if (localOpcode == Opcode.PING)
    {
      paramWebSocketImpl.getWebSocketListener().onWebsocketPing(paramWebSocketImpl, paramFramedata);
      return;
    }
    if (localOpcode == Opcode.PONG)
    {
      paramWebSocketImpl.updateLastPong();
      paramWebSocketImpl.getWebSocketListener().onWebsocketPong(paramWebSocketImpl, paramFramedata);
      return;
    }
    if ((!paramFramedata.isFin()) || (localOpcode == Opcode.CONTINUOUS))
    {
      processFrameContinuousAndNonFin(paramWebSocketImpl, paramFramedata, localOpcode);
      return;
    }
    if (this.currentContinuousFrame != null)
    {
      log.error("Protocol error: Continuous frame sequence not completed.");
      throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
    }
    if (localOpcode == Opcode.TEXT)
    {
      processFrameText(paramWebSocketImpl, paramFramedata);
      return;
    }
    if (localOpcode == Opcode.BINARY)
    {
      processFrameBinary(paramWebSocketImpl, paramFramedata);
      return;
    }
    log.error("non control or continious frame expected");
    throw new InvalidDataException(1002, "non control or continious frame expected");
  }
  
  public void reset()
  {
    this.incompleteframe = null;
    if (this.extension != null) {
      this.extension.reset();
    }
    this.extension = new DefaultExtension();
    this.protocol = null;
  }
  
  public String toString()
  {
    Object localObject2 = super.toString();
    Object localObject1 = localObject2;
    if (getExtension() != null) {
      localObject1 = (String)localObject2 + " extension: " + getExtension().toString();
    }
    localObject2 = localObject1;
    if (getProtocol() != null) {
      localObject2 = (String)localObject1 + " protocol: " + getProtocol().toString();
    }
    return (String)localObject2 + " max frame size: " + this.maxFrameSize;
  }
  
  public List<Framedata> translateFrame(ByteBuffer paramByteBuffer)
    throws InvalidDataException
  {
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      if (this.incompleteframe != null) {}
      try
      {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.incompleteframe.remaining();
        if (j > i)
        {
          this.incompleteframe.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(i + paramByteBuffer.position());
          return Collections.emptyList();
        }
        this.incompleteframe.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        localLinkedList.add(translateSingleFrame((ByteBuffer)this.incompleteframe.duplicate().position(0)));
        this.incompleteframe = null;
        while (paramByteBuffer.hasRemaining())
        {
          paramByteBuffer.mark();
          try
          {
            localLinkedList.add(translateSingleFrame(paramByteBuffer));
          }
          catch (IncompleteException localIncompleteException2)
          {
            paramByteBuffer.reset();
            this.incompleteframe = ByteBuffer.allocate(checkAlloc(localIncompleteException2.getPreferredSize()));
            this.incompleteframe.put(paramByteBuffer);
          }
        }
        return localLinkedList;
      }
      catch (IncompleteException localIncompleteException1)
      {
        ByteBuffer localByteBuffer = ByteBuffer.allocate(checkAlloc(localIncompleteException1.getPreferredSize()));
        assert (localByteBuffer.limit() > this.incompleteframe.limit());
        this.incompleteframe.rewind();
        localByteBuffer.put(this.incompleteframe);
        this.incompleteframe = localByteBuffer;
      }
    }
  }
  
  class TranslatedPayloadMetaData
  {
    private int payloadLength;
    private int realPackageSize;
    
    TranslatedPayloadMetaData(int paramInt1, int paramInt2)
    {
      this.payloadLength = paramInt1;
      this.realPackageSize = paramInt2;
    }
    
    private int getPayloadLength()
    {
      return this.payloadLength;
    }
    
    private int getRealPackageSize()
    {
      return this.realPackageSize;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.drafts.Draft_6455
 * JD-Core Version:    0.7.0.1
 */