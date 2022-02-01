package com.tencent.moai.mailsdk.protocol.mime;

public class MimeDefine
{
  public static String ALTERNATIVE;
  public static String APPLICATION;
  public static String APPLICATION_OCTET_STREAM;
  public static String BASE64;
  public static String BCC;
  public static String BINARY;
  public static String BOUNDARY;
  public static String CALENDAR;
  public static String CC;
  public static String CHARSET;
  public static String CONTENT_DESCRIPTION;
  public static String CONTENT_DISPOSITION;
  public static String CONTENT_ENCODING;
  public static String CONTENT_ID;
  public static String CONTENT_LANGUAGE;
  public static String CONTENT_MD5;
  public static String CONTENT_TYPE;
  public static String CRLF = "\r\n";
  public static String DATE = "Date";
  public static String DIGEST;
  public static String DISPOSITION_ATTACHMENT;
  public static String DISPOSITION_INLINE;
  public static String DOT;
  public static String FILE_NAME;
  public static String FROM;
  public static String HTML;
  public static String MESSAGE;
  public static String MESSAGE_ID;
  public static String MESSAGE_RFC;
  public static String MIME_VERSION;
  public static String MIME_VERSION_VALUE;
  public static String MIME_X_MAILER;
  public static String MIME_X_MAILER_VALUE;
  public static String MIME_X_QQ_MAILER;
  public static String MIME_X_QQ_MAILER_VALUE;
  public static String MIME_X_QQ_MIME;
  public static String MIME_X_QQ_MIME_VALUE;
  public static String MIXED;
  public static String MULTIPART;
  public static String MULTIPART_ALTERNATIVE;
  public static String MULTIPART_DIGEST;
  public static String MULTIPART_MIXED;
  public static String MULTIPART_RELATED;
  public static String MULTIPART_REPORT;
  public static String NAME;
  public static String NIL;
  public static String OCTET_STREAM;
  public static String PLAIN;
  public static String QUOTED_PRINTABLE;
  public static String RECEIVED = "Received";
  public static String RELATED;
  public static String REPLY_TO;
  public static String RFC;
  public static String SUBJECT;
  public static String TEXT;
  public static String TEXT_CALENDAR;
  public static String TEXT_HTML;
  public static String TEXT_PLAIN;
  public static String TO;
  public static String US_ASCII = "us-ascii";
  public static String UUENCODE;
  public static String X_UNKNOWN = "x-unknown";
  public static String X_UUE;
  public static String X_UUENCODE;
  public static String _7BIT;
  public static String _8BIT;
  
  static
  {
    FROM = "From";
    REPLY_TO = "Reply-To";
    TO = "To";
    CC = "Cc";
    BCC = "Bcc";
    SUBJECT = "Subject";
    MESSAGE_ID = "Message-ID";
    MIME_VERSION = "Mime-Version";
    MIME_VERSION_VALUE = "1.0";
    MIME_X_QQ_MIME = "X-QQ-MIME";
    MIME_X_QQ_MIME_VALUE = "TCMime 1.0 by Tencent";
    MIME_X_MAILER = "X-Mailer";
    MIME_X_MAILER_VALUE = "QQMail 2.x";
    MIME_X_QQ_MAILER = "X-QQ-Mailer";
    MIME_X_QQ_MAILER_VALUE = "QQMail 2.x";
    BOUNDARY = "boundary";
    CHARSET = "charset";
    CONTENT_TYPE = "Content-Type";
    CONTENT_ENCODING = "Content-Transfer-Encoding";
    CONTENT_ID = "Content-Id";
    CONTENT_MD5 = "Content-MD5";
    CONTENT_LANGUAGE = "Content-Language";
    CONTENT_DESCRIPTION = "Content-Description";
    CONTENT_DISPOSITION = "Content-Disposition";
    MULTIPART = "multipart";
    MULTIPART_MIXED = "multipart/mixed";
    MULTIPART_RELATED = "multipart/related";
    MULTIPART_ALTERNATIVE = "multipart/alternative";
    MULTIPART_DIGEST = "multipart/digest";
    MULTIPART_REPORT = "multipart/report";
    MIXED = "mixed";
    RELATED = "related";
    ALTERNATIVE = "alternative";
    DIGEST = "digest";
    APPLICATION_OCTET_STREAM = "application/octet-stream";
    TEXT_HTML = "text/html";
    TEXT_PLAIN = "text/plain";
    TEXT_CALENDAR = "text/calendar";
    TEXT = "text";
    PLAIN = "plain";
    HTML = "html";
    CALENDAR = "calendar";
    APPLICATION = "application";
    OCTET_STREAM = "octet-stream";
    MESSAGE_RFC = "message/rfc822";
    BASE64 = "base64";
    QUOTED_PRINTABLE = "quoted-printable";
    UUENCODE = "uuencode";
    X_UUENCODE = "x-uuencode";
    X_UUE = "x-uue";
    BINARY = "binary";
    _7BIT = "7bit";
    _8BIT = "8bit";
    NAME = "name";
    FILE_NAME = "filename";
    DISPOSITION_INLINE = "inline";
    DISPOSITION_ATTACHMENT = "attachment";
    MESSAGE = "message";
    RFC = "rfc822";
    NIL = "nil";
    DOT = ".";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.MimeDefine
 * JD-Core Version:    0.7.0.1
 */