package org.mickey.framework.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author mickey
 * 2020-02-14
 */
@Slf4j
public class MIMEUtil {
    private static final Map<String, String> mediaTypes = new HashMap<>();

    static {
        mediaTypes.put(".323", "text/h323");
        mediaTypes.put(".3g2", "video/3gpp2");
        mediaTypes.put(".3gp", "video/3gpp");
        mediaTypes.put(".3gp2", "video/3gpp2");
        mediaTypes.put(".3gpp", "video/3gpp");
        mediaTypes.put(".7z", "application/x-7z-compressed");
        mediaTypes.put(".aa", "audio/audible");
        mediaTypes.put(".AAC", "audio/aac");
        mediaTypes.put(".aaf", "application/octet-stream");
        mediaTypes.put(".aax", "audio/vnd.audible.aax");
        mediaTypes.put(".ac3", "audio/ac3");
        mediaTypes.put(".aca", "application/octet-stream");
        mediaTypes.put(".accda", "application/msaccess.addin");
        mediaTypes.put(".accdb", "application/msaccess");
        mediaTypes.put(".accdc", "application/msaccess.cab");
        mediaTypes.put(".accde", "application/msaccess");
        mediaTypes.put(".accdr", "application/msaccess.runtime");
        mediaTypes.put(".accdt", "application/msaccess");
        mediaTypes.put(".accdw", "application/msaccess.webapplication");
        mediaTypes.put(".accft", "application/msaccess.ftemplate");
        mediaTypes.put(".acx", "application/internet-property-stream");
        mediaTypes.put(".AddIn", "text/xml");
        mediaTypes.put(".ade", "application/msaccess");
        mediaTypes.put(".adobebridge", "application/x-bridge-url");
        mediaTypes.put(".adp", "application/msaccess");
        mediaTypes.put(".ADT", "audio/vnd.dlna.adts");
        mediaTypes.put(".ADTS", "audio/aac");
        mediaTypes.put(".afm", "application/octet-stream");
        mediaTypes.put(".ai", "application/postscript");
        mediaTypes.put(".aif", "audio/aiff");
        mediaTypes.put(".aifc", "audio/aiff");
        mediaTypes.put(".aiff", "audio/aiff");
        mediaTypes.put(".air", "application/vnd.adobe.air-application-installer-package+zip");
        mediaTypes.put(".amc", "application/mpeg");
        mediaTypes.put(".anx", "application/annodex");
        mediaTypes.put(".apk", "application/vnd.android.package-archive");
        mediaTypes.put(".application", "application/x-ms-application");
        mediaTypes.put(".art", "image/x-jg");
        mediaTypes.put(".asa", "application/xml");
        mediaTypes.put(".asax", "application/xml");
        mediaTypes.put(".ascx", "application/xml");
        mediaTypes.put(".asd", "application/octet-stream");
        mediaTypes.put(".asf", "video/x-ms-asf");
        mediaTypes.put(".ashx", "application/xml");
        mediaTypes.put(".asi", "application/octet-stream");
        mediaTypes.put(".asm", "text/plain");
        mediaTypes.put(".asmx", "application/xml");
        mediaTypes.put(".aspx", "application/xml");
        mediaTypes.put(".asr", "video/x-ms-asf");
        mediaTypes.put(".asx", "video/x-ms-asf");
        mediaTypes.put(".atom", "application/atom+xml");
        mediaTypes.put(".au", "audio/basic");
        mediaTypes.put(".avi", "video/x-msvideo");
        mediaTypes.put(".axa", "audio/annodex");
        mediaTypes.put(".axs", "application/olescript");
        mediaTypes.put(".axv", "video/annodex");
        mediaTypes.put(".bas", "text/plain");
        mediaTypes.put(".bcpio", "application/x-bcpio");
        mediaTypes.put(".bin", "application/octet-stream");
        mediaTypes.put(".bmp", "image/bmp");
        mediaTypes.put(".c", "text/plain");
        mediaTypes.put(".cab", "application/octet-stream");
        mediaTypes.put(".caf", "audio/x-caf");
        mediaTypes.put(".calx", "application/vnd.ms-office.calx");
        mediaTypes.put(".cat", "application/vnd.ms-pki.seccat");
        mediaTypes.put(".cc", "text/plain");
        mediaTypes.put(".cd", "text/plain");
        mediaTypes.put(".cdda", "audio/aiff");
        mediaTypes.put(".cdf", "application/x-cdf");
        mediaTypes.put(".cer", "application/x-x509-ca-cert");
        mediaTypes.put(".cfg", "text/plain");
        mediaTypes.put(".chm", "application/octet-stream");
        mediaTypes.put(".class", "application/x-java-applet");
        mediaTypes.put(".clp", "application/x-msclip");
        mediaTypes.put(".cmd", "text/plain");
        mediaTypes.put(".cmx", "image/x-cmx");
        mediaTypes.put(".cnf", "text/plain");
        mediaTypes.put(".cod", "image/cis-cod");
        mediaTypes.put(".config", "application/xml");
        mediaTypes.put(".contact", "text/x-ms-contact");
        mediaTypes.put(".coverage", "application/xml");
        mediaTypes.put(".cpio", "application/x-cpio");
        mediaTypes.put(".cpp", "text/plain");
        mediaTypes.put(".crd", "application/x-mscardfile");
        mediaTypes.put(".crl", "application/pkix-crl");
        mediaTypes.put(".crt", "application/x-x509-ca-cert");
        mediaTypes.put(".cs", "text/plain");
        mediaTypes.put(".csdproj", "text/plain");
        mediaTypes.put(".csh", "application/x-csh");
        mediaTypes.put(".csproj", "text/plain");
        mediaTypes.put(".css", "text/css");
        mediaTypes.put(".csv", "text/csv");
        mediaTypes.put(".cur", "application/octet-stream");
        mediaTypes.put(".cxx", "text/plain");
        mediaTypes.put(".dat", "application/octet-stream");
        mediaTypes.put(".datasource", "application/xml");
        mediaTypes.put(".dbproj", "text/plain");
        mediaTypes.put(".dcr", "application/x-director");
        mediaTypes.put(".def", "text/plain");
        mediaTypes.put(".deploy", "application/octet-stream");
        mediaTypes.put(".der", "application/x-x509-ca-cert");
        mediaTypes.put(".dgml", "application/xml");
        mediaTypes.put(".dib", "image/bmp");
        mediaTypes.put(".dif", "video/x-dv");
        mediaTypes.put(".dir", "application/x-director");
        mediaTypes.put(".disco", "text/xml");
        mediaTypes.put(".divx", "video/divx");
        mediaTypes.put(".dll", "application/x-msdownload");
        mediaTypes.put(".dll.config", "text/xml");
        mediaTypes.put(".dlm", "text/dlm");
        mediaTypes.put(".doc", "application/msword");
        mediaTypes.put(".docm", "application/vnd.ms-word.document.macroEnabled.12");
        mediaTypes.put(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        mediaTypes.put(".dot", "application/msword");
        mediaTypes.put(".dotm", "application/vnd.ms-word.template.macroEnabled.12");
        mediaTypes.put(".dotx", "application/vnd.openxmlformats-officedocument.wordprocessingml.template");
        mediaTypes.put(".dsp", "application/octet-stream");
        mediaTypes.put(".dsw", "text/plain");
        mediaTypes.put(".dtd", "text/xml");
        mediaTypes.put(".dtsConfig", "text/xml");
        mediaTypes.put(".dv", "video/x-dv");
        mediaTypes.put(".dvi", "application/x-dvi");
        mediaTypes.put(".dwf", "drawing/x-dwf");
        mediaTypes.put(".dwg", "application/acad");
        mediaTypes.put(".dwp", "application/octet-stream");
        mediaTypes.put(".dxf", "application/x-dxf");
        mediaTypes.put(".dxr", "application/x-director");
        mediaTypes.put(".eml", "message/rfc822");
        mediaTypes.put(".emz", "application/octet-stream");
        mediaTypes.put(".eot", "application/vnd.ms-fontobject");
        mediaTypes.put(".eps", "application/postscript");
        mediaTypes.put(".es", "application/ecmascript");
        mediaTypes.put(".etl", "application/etl");
        mediaTypes.put(".etx", "text/x-setext");
        mediaTypes.put(".evy", "application/envoy");
        mediaTypes.put(".exe", "application/octet-stream");
        mediaTypes.put(".exe.config", "text/xml");
        mediaTypes.put(".fdf", "application/vnd.fdf");
        mediaTypes.put(".fif", "application/fractals");
        mediaTypes.put(".filters", "application/xml");
        mediaTypes.put(".fla", "application/octet-stream");
        mediaTypes.put(".flac", "audio/flac");
        mediaTypes.put(".flr", "x-world/x-vrml");
        mediaTypes.put(".flv", "video/x-flv");
        mediaTypes.put(".fsscript", "application/fsharp-script");
        mediaTypes.put(".fsx", "application/fsharp-script");
        mediaTypes.put(".generictest", "application/xml");
        mediaTypes.put(".gif", "image/gif");
        mediaTypes.put(".gpx", "application/gpx+xml");
        mediaTypes.put(".group", "text/x-ms-group");
        mediaTypes.put(".gsm", "audio/x-gsm");
        mediaTypes.put(".gtar", "application/x-gtar");
        mediaTypes.put(".gz", "application/x-gzip");
        mediaTypes.put(".h", "text/plain");
        mediaTypes.put(".hdf", "application/x-hdf");
        mediaTypes.put(".hdml", "text/x-hdml");
        mediaTypes.put(".hhc", "application/x-oleobject");
        mediaTypes.put(".hhk", "application/octet-stream");
        mediaTypes.put(".hhp", "application/octet-stream");
        mediaTypes.put(".hlp", "application/winhlp");
        mediaTypes.put(".hpp", "text/plain");
        mediaTypes.put(".hqx", "application/mac-binhex40");
        mediaTypes.put(".hta", "application/hta");
        mediaTypes.put(".htc", "text/x-component");
        mediaTypes.put(".htm", "text/html");
        mediaTypes.put(".html", "text/html");
        mediaTypes.put(".htt", "text/webviewhtml");
        mediaTypes.put(".hxa", "application/xml");
        mediaTypes.put(".hxc", "application/xml");
        mediaTypes.put(".hxd", "application/octet-stream");
        mediaTypes.put(".hxe", "application/xml");
        mediaTypes.put(".hxf", "application/xml");
        mediaTypes.put(".hxh", "application/octet-stream");
        mediaTypes.put(".hxi", "application/octet-stream");
        mediaTypes.put(".hxk", "application/xml");
        mediaTypes.put(".hxq", "application/octet-stream");
        mediaTypes.put(".hxr", "application/octet-stream");
        mediaTypes.put(".hxs", "application/octet-stream");
        mediaTypes.put(".hxt", "text/html");
        mediaTypes.put(".hxv", "application/xml");
        mediaTypes.put(".hxw", "application/octet-stream");
        mediaTypes.put(".hxx", "text/plain");
        mediaTypes.put(".i", "text/plain");
        mediaTypes.put(".ico", "image/x-icon");
        mediaTypes.put(".ics", "application/octet-stream");
        mediaTypes.put(".idl", "text/plain");
        mediaTypes.put(".ief", "image/ief");
        mediaTypes.put(".iii", "application/x-iphone");
        mediaTypes.put(".inc", "text/plain");
        mediaTypes.put(".inf", "application/octet-stream");
        mediaTypes.put(".ini", "text/plain");
        mediaTypes.put(".inl", "text/plain");
        mediaTypes.put(".ins", "application/x-internet-signup");
        mediaTypes.put(".ipa", "application/x-itunes-ipa");
        mediaTypes.put(".ipg", "application/x-itunes-ipg");
        mediaTypes.put(".ipproj", "text/plain");
        mediaTypes.put(".ipsw", "application/x-itunes-ipsw");
        mediaTypes.put(".iqy", "text/x-ms-iqy");
        mediaTypes.put(".isp", "application/x-internet-signup");
        mediaTypes.put(".ite", "application/x-itunes-ite");
        mediaTypes.put(".itlp", "application/x-itunes-itlp");
        mediaTypes.put(".itms", "application/x-itunes-itms");
        mediaTypes.put(".itpc", "application/x-itunes-itpc");
        mediaTypes.put(".IVF", "video/x-ivf");
        mediaTypes.put(".jar", "application/java-archive");
        mediaTypes.put(".java", "application/octet-stream");
        mediaTypes.put(".jck", "application/liquidmotion");
        mediaTypes.put(".jcz", "application/liquidmotion");
        mediaTypes.put(".jfif", "image/pjpeg");
        mediaTypes.put(".jnlp", "application/x-java-jnlp-file");
        mediaTypes.put(".jpb", "application/octet-stream");
        mediaTypes.put(".jpe", "image/jpeg");
        mediaTypes.put(".jpeg", "image/jpeg");
        mediaTypes.put(".jpg", "image/jpeg");
        mediaTypes.put(".js", "application/javascript");
        mediaTypes.put(".json", "application/json");
        mediaTypes.put(".jsx", "text/jscript");
        mediaTypes.put(".jsxbin", "text/plain");
        mediaTypes.put(".latex", "application/x-latex");
        mediaTypes.put(".library-ms", "application/windows-library+xml");
        mediaTypes.put(".lit", "application/x-ms-reader");
        mediaTypes.put(".loadtest", "application/xml");
        mediaTypes.put(".lpk", "application/octet-stream");
        mediaTypes.put(".lsf", "video/x-la-asf");
        mediaTypes.put(".lst", "text/plain");
        mediaTypes.put(".lsx", "video/x-la-asf");
        mediaTypes.put(".lzh", "application/octet-stream");
        mediaTypes.put(".m13", "application/x-msmediaview");
        mediaTypes.put(".m14", "application/x-msmediaview");
        mediaTypes.put(".m1v", "video/mpeg");
        mediaTypes.put(".m2t", "video/vnd.dlna.mpeg-tts");
        mediaTypes.put(".m2ts", "video/vnd.dlna.mpeg-tts");
        mediaTypes.put(".m2v", "video/mpeg");
        mediaTypes.put(".m3u", "audio/x-mpegurl");
        mediaTypes.put(".m3u8", "audio/x-mpegurl");
        mediaTypes.put(".m4a", "audio/m4a");
        mediaTypes.put(".m4b", "audio/m4b");
        mediaTypes.put(".m4p", "audio/m4p");
        mediaTypes.put(".m4r", "audio/x-m4r");
        mediaTypes.put(".m4v", "video/x-m4v");
        mediaTypes.put(".mac", "image/x-macpaint");
        mediaTypes.put(".mak", "text/plain");
        mediaTypes.put(".man", "application/x-troff-man");
        mediaTypes.put(".manifest", "application/x-ms-manifest");
        mediaTypes.put(".map", "text/plain");
        mediaTypes.put(".master", "application/xml");
        mediaTypes.put(".mbox", "application/mbox");
        mediaTypes.put(".mda", "application/msaccess");
        mediaTypes.put(".mdb", "application/x-msaccess");
        mediaTypes.put(".mde", "application/msaccess");
        mediaTypes.put(".mdp", "application/octet-stream");
        mediaTypes.put(".me", "application/x-troff-me");
        mediaTypes.put(".mfp", "application/x-shockwave-flash");
        mediaTypes.put(".mht", "message/rfc822");
        mediaTypes.put(".mhtml", "message/rfc822");
        mediaTypes.put(".mid", "audio/mid");
        mediaTypes.put(".midi", "audio/mid");
        mediaTypes.put(".mix", "application/octet-stream");
        mediaTypes.put(".mk", "text/plain");
        mediaTypes.put(".mk3d", "video/x-matroska-3d");
        mediaTypes.put(".mka", "audio/x-matroska");
        mediaTypes.put(".mkv", "video/x-matroska");
        mediaTypes.put(".mmf", "application/x-smaf");
        mediaTypes.put(".mno", "text/xml");
        mediaTypes.put(".mny", "application/x-msmoney");
        mediaTypes.put(".mod", "video/mpeg");
        mediaTypes.put(".mov", "video/quicktime");
        mediaTypes.put(".movie", "video/x-sgi-movie");
        mediaTypes.put(".mp2", "video/mpeg");
        mediaTypes.put(".mp2v", "video/mpeg");
        mediaTypes.put(".mp3", "audio/mpeg");
        mediaTypes.put(".mp4", "video/mp4");
        mediaTypes.put(".mp4v", "video/mp4");
        mediaTypes.put(".mpa", "video/mpeg");
        mediaTypes.put(".mpe", "video/mpeg");
        mediaTypes.put(".mpeg", "video/mpeg");
        mediaTypes.put(".mpf", "application/vnd.ms-mediapackage");
        mediaTypes.put(".mpg", "video/mpeg");
        mediaTypes.put(".mpp", "application/vnd.ms-project");
        mediaTypes.put(".mpv2", "video/mpeg");
        mediaTypes.put(".mqv", "video/quicktime");
        mediaTypes.put(".ms", "application/x-troff-ms");
        mediaTypes.put(".msg", "application/vnd.ms-outlook");
        mediaTypes.put(".msi", "application/octet-stream");
        mediaTypes.put(".mso", "application/octet-stream");
        mediaTypes.put(".mts", "video/vnd.dlna.mpeg-tts");
        mediaTypes.put(".mtx", "application/xml");
        mediaTypes.put(".mvb", "application/x-msmediaview");
        mediaTypes.put(".mvc", "application/x-miva-compiled");
        mediaTypes.put(".mxp", "application/x-mmxp");
        mediaTypes.put(".nc", "application/x-netcdf");
        mediaTypes.put(".nsc", "video/x-ms-asf");
        mediaTypes.put(".nws", "message/rfc822");
        mediaTypes.put(".ocx", "application/octet-stream");
        mediaTypes.put(".oda", "application/oda");
        mediaTypes.put(".odb", "application/vnd.oasis.opendocument.database");
        mediaTypes.put(".odc", "application/vnd.oasis.opendocument.chart");
        mediaTypes.put(".odf", "application/vnd.oasis.opendocument.formula");
        mediaTypes.put(".odg", "application/vnd.oasis.opendocument.graphics");
        mediaTypes.put(".odh", "text/plain");
        mediaTypes.put(".odi", "application/vnd.oasis.opendocument.image");
        mediaTypes.put(".odl", "text/plain");
        mediaTypes.put(".odm", "application/vnd.oasis.opendocument.text-master");
        mediaTypes.put(".odp", "application/vnd.oasis.opendocument.presentation");
        mediaTypes.put(".ods", "application/vnd.oasis.opendocument.spreadsheet");
        mediaTypes.put(".odt", "application/vnd.oasis.opendocument.text");
        mediaTypes.put(".oga", "audio/ogg");
        mediaTypes.put(".ogg", "audio/ogg");
        mediaTypes.put(".ogv", "video/ogg");
        mediaTypes.put(".ogx", "application/ogg");
        mediaTypes.put(".one", "application/onenote");
        mediaTypes.put(".onea", "application/onenote");
        mediaTypes.put(".onepkg", "application/onenote");
        mediaTypes.put(".onetmp", "application/onenote");
        mediaTypes.put(".onetoc", "application/onenote");
        mediaTypes.put(".onetoc2", "application/onenote");
        mediaTypes.put(".opus", "audio/ogg");
        mediaTypes.put(".orderedtest", "application/xml");
        mediaTypes.put(".osdx", "application/opensearchdescription+xml");
        mediaTypes.put(".otf", "application/font-sfnt");
        mediaTypes.put(".otg", "application/vnd.oasis.opendocument.graphics-template");
        mediaTypes.put(".oth", "application/vnd.oasis.opendocument.text-web");
        mediaTypes.put(".otp", "application/vnd.oasis.opendocument.presentation-template");
        mediaTypes.put(".ots", "application/vnd.oasis.opendocument.spreadsheet-template");
        mediaTypes.put(".ott", "application/vnd.oasis.opendocument.text-template");
        mediaTypes.put(".oxt", "application/vnd.openofficeorg.extension");
        mediaTypes.put(".p10", "application/pkcs10");
        mediaTypes.put(".p12", "application/x-pkcs12");
        mediaTypes.put(".p7b", "application/x-pkcs7-certificates");
        mediaTypes.put(".p7c", "application/pkcs7-mime");
        mediaTypes.put(".p7m", "application/pkcs7-mime");
        mediaTypes.put(".p7r", "application/x-pkcs7-certreqresp");
        mediaTypes.put(".p7s", "application/pkcs7-signature");
        mediaTypes.put(".pbm", "image/x-portable-bitmap");
        mediaTypes.put(".pcast", "application/x-podcast");
        mediaTypes.put(".pct", "image/pict");
        mediaTypes.put(".pcx", "application/octet-stream");
        mediaTypes.put(".pcz", "application/octet-stream");
        mediaTypes.put(".pdf", "application/pdf");
        mediaTypes.put(".pfb", "application/octet-stream");
        mediaTypes.put(".pfm", "application/octet-stream");
        mediaTypes.put(".pfx", "application/x-pkcs12");
        mediaTypes.put(".pgm", "image/x-portable-graymap");
        mediaTypes.put(".pic", "image/pict");
        mediaTypes.put(".pict", "image/pict");
        mediaTypes.put(".pkgdef", "text/plain");
        mediaTypes.put(".pkgundef", "text/plain");
        mediaTypes.put(".pko", "application/vnd.ms-pki.pko");
        mediaTypes.put(".pls", "audio/scpls");
        mediaTypes.put(".pma", "application/x-perfmon");
        mediaTypes.put(".pmc", "application/x-perfmon");
        mediaTypes.put(".pml", "application/x-perfmon");
        mediaTypes.put(".pmr", "application/x-perfmon");
        mediaTypes.put(".pmw", "application/x-perfmon");
        mediaTypes.put(".png", "image/png");
        mediaTypes.put(".pnm", "image/x-portable-anymap");
        mediaTypes.put(".pnt", "image/x-macpaint");
        mediaTypes.put(".pntg", "image/x-macpaint");
        mediaTypes.put(".pnz", "image/png");
        mediaTypes.put(".pot", "application/vnd.ms-powerpoint");
        mediaTypes.put(".potm", "application/vnd.ms-powerpoint.template.macroEnabled.12");
        mediaTypes.put(".potx", "application/vnd.openxmlformats-officedocument.presentationml.template");
        mediaTypes.put(".ppa", "application/vnd.ms-powerpoint");
        mediaTypes.put(".ppam", "application/vnd.ms-powerpoint.addin.macroEnabled.12");
        mediaTypes.put(".ppm", "image/x-portable-pixmap");
        mediaTypes.put(".pps", "application/vnd.ms-powerpoint");
        mediaTypes.put(".ppsm", "application/vnd.ms-powerpoint.slideshow.macroEnabled.12");
        mediaTypes.put(".ppsx", "application/vnd.openxmlformats-officedocument.presentationml.slideshow");
        mediaTypes.put(".ppt", "application/vnd.ms-powerpoint");
        mediaTypes.put(".pptm", "application/vnd.ms-powerpoint.presentation.macroEnabled.12");
        mediaTypes.put(".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        mediaTypes.put(".prf", "application/pics-rules");
        mediaTypes.put(".prm", "application/octet-stream");
        mediaTypes.put(".prx", "application/octet-stream");
        mediaTypes.put(".ps", "application/postscript");
        mediaTypes.put(".psc1", "application/PowerShell");
        mediaTypes.put(".psd", "application/octet-stream");
        mediaTypes.put(".psess", "application/xml");
        mediaTypes.put(".psm", "application/octet-stream");
        mediaTypes.put(".psp", "application/octet-stream");
        mediaTypes.put(".pst", "application/vnd.ms-outlook");
        mediaTypes.put(".pub", "application/x-mspublisher");
        mediaTypes.put(".pwz", "application/vnd.ms-powerpoint");
        mediaTypes.put(".qht", "text/x-html-insertion");
        mediaTypes.put(".qhtm", "text/x-html-insertion");
        mediaTypes.put(".qt", "video/quicktime");
        mediaTypes.put(".qti", "image/x-quicktime");
        mediaTypes.put(".qtif", "image/x-quicktime");
        mediaTypes.put(".qtl", "application/x-quicktimeplayer");
        mediaTypes.put(".qxd", "application/octet-stream");
        mediaTypes.put(".ra", "audio/x-pn-realaudio");
        mediaTypes.put(".ram", "audio/x-pn-realaudio");
        mediaTypes.put(".rar", "application/x-rar-compressed");
        mediaTypes.put(".ras", "image/x-cmu-raster");
        mediaTypes.put(".rat", "application/rat-file");
        mediaTypes.put(".rc", "text/plain");
        mediaTypes.put(".rc2", "text/plain");
        mediaTypes.put(".rct", "text/plain");
        mediaTypes.put(".rdlc", "application/xml");
        mediaTypes.put(".reg", "text/plain");
        mediaTypes.put(".resx", "application/xml");
        mediaTypes.put(".rf", "image/vnd.rn-realflash");
        mediaTypes.put(".rgb", "image/x-rgb");
        mediaTypes.put(".rgs", "text/plain");
        mediaTypes.put(".rm", "application/vnd.rn-realmedia");
        mediaTypes.put(".rmi", "audio/mid");
        mediaTypes.put(".rmp", "application/vnd.rn-rn_music_package");
        mediaTypes.put(".roff", "application/x-troff");
        mediaTypes.put(".rpm", "audio/x-pn-realaudio-plugin");
        mediaTypes.put(".rqy", "text/x-ms-rqy");
        mediaTypes.put(".rtf", "application/rtf");
        mediaTypes.put(".rtx", "text/richtext");
        mediaTypes.put(".rvt", "application/octet-stream");
        mediaTypes.put(".ruleset", "application/xml");
        mediaTypes.put(".s", "text/plain");
        mediaTypes.put(".safariextz", "application/x-safari-safariextz");
        mediaTypes.put(".scd", "application/x-msschedule");
        mediaTypes.put(".scr", "text/plain");
        mediaTypes.put(".sct", "text/scriptlet");
        mediaTypes.put(".sd2", "audio/x-sd2");
        mediaTypes.put(".sdp", "application/sdp");
        mediaTypes.put(".sea", "application/octet-stream");
        mediaTypes.put(".searchConnector-ms", "application/windows-search-connector+xml");
        mediaTypes.put(".setpay", "application/set-payment-initiation");
        mediaTypes.put(".setreg", "application/set-registration-initiation");
        mediaTypes.put(".settings", "application/xml");
        mediaTypes.put(".sgimb", "application/x-sgimb");
        mediaTypes.put(".sgml", "text/sgml");
        mediaTypes.put(".sh", "application/x-sh");
        mediaTypes.put(".shar", "application/x-shar");
        mediaTypes.put(".shtml", "text/html");
        mediaTypes.put(".sit", "application/x-stuffit");
        mediaTypes.put(".sitemap", "application/xml");
        mediaTypes.put(".skin", "application/xml");
        mediaTypes.put(".skp", "application/x-koan");
        mediaTypes.put(".sldm", "application/vnd.ms-powerpoint.slide.macroEnabled.12");
        mediaTypes.put(".sldx", "application/vnd.openxmlformats-officedocument.presentationml.slide");
        mediaTypes.put(".slk", "application/vnd.ms-excel");
        mediaTypes.put(".sln", "text/plain");
        mediaTypes.put(".slupkg-ms", "application/x-ms-license");
        mediaTypes.put(".smd", "audio/x-smd");
        mediaTypes.put(".smi", "application/octet-stream");
        mediaTypes.put(".smx", "audio/x-smd");
        mediaTypes.put(".smz", "audio/x-smd");
        mediaTypes.put(".snd", "audio/basic");
        mediaTypes.put(".snippet", "application/xml");
        mediaTypes.put(".snp", "application/octet-stream");
        mediaTypes.put(".sol", "text/plain");
        mediaTypes.put(".sor", "text/plain");
        mediaTypes.put(".spc", "application/x-pkcs7-certificates");
        mediaTypes.put(".spl", "application/futuresplash");
        mediaTypes.put(".spx", "audio/ogg");
        mediaTypes.put(".src", "application/x-wais-source");
        mediaTypes.put(".srf", "text/plain");
        mediaTypes.put(".SSISDeploymentManifest", "text/xml");
        mediaTypes.put(".ssm", "application/streamingmedia");
        mediaTypes.put(".sst", "application/vnd.ms-pki.certstore");
        mediaTypes.put(".stl", "application/vnd.ms-pki.stl");
        mediaTypes.put(".sv4cpio", "application/x-sv4cpio");
        mediaTypes.put(".sv4crc", "application/x-sv4crc");
        mediaTypes.put(".svc", "application/xml");
        mediaTypes.put(".svg", "image/svg+xml");
        mediaTypes.put(".swf", "application/x-shockwave-flash");
        mediaTypes.put(".step", "application/step");
        mediaTypes.put(".stp", "application/step");
        mediaTypes.put(".t", "application/x-troff");
        mediaTypes.put(".tar", "application/x-tar");
        mediaTypes.put(".tcl", "application/x-tcl");
        mediaTypes.put(".testrunconfig", "application/xml");
        mediaTypes.put(".testsettings", "application/xml");
        mediaTypes.put(".tex", "application/x-tex");
        mediaTypes.put(".texi", "application/x-texinfo");
        mediaTypes.put(".texinfo", "application/x-texinfo");
        mediaTypes.put(".tgz", "application/x-compressed");
        mediaTypes.put(".thmx", "application/vnd.ms-officetheme");
        mediaTypes.put(".thn", "application/octet-stream");
        mediaTypes.put(".tif", "image/tiff");
        mediaTypes.put(".tiff", "image/tiff");
        mediaTypes.put(".tlh", "text/plain");
        mediaTypes.put(".tli", "text/plain");
        mediaTypes.put(".toc", "application/octet-stream");
        mediaTypes.put(".tr", "application/x-troff");
        mediaTypes.put(".trm", "application/x-msterminal");
        mediaTypes.put(".trx", "application/xml");
        mediaTypes.put(".ts", "video/vnd.dlna.mpeg-tts");
        mediaTypes.put(".tsv", "text/tab-separated-values");
        mediaTypes.put(".ttf", "application/font-sfnt");
        mediaTypes.put(".tts", "video/vnd.dlna.mpeg-tts");
        mediaTypes.put(".txt", "text/plain");
        mediaTypes.put(".u32", "application/octet-stream");
        mediaTypes.put(".uls", "text/iuls");
        mediaTypes.put(".user", "text/plain");
        mediaTypes.put(".ustar", "application/x-ustar");
        mediaTypes.put(".vb", "text/plain");
        mediaTypes.put(".vbdproj", "text/plain");
        mediaTypes.put(".vbk", "video/mpeg");
        mediaTypes.put(".vbproj", "text/plain");
        mediaTypes.put(".vbs", "text/vbscript");
        mediaTypes.put(".vcf", "text/x-vcard");
        mediaTypes.put(".vcproj", "application/xml");
        mediaTypes.put(".vcs", "text/plain");
        mediaTypes.put(".vcxproj", "application/xml");
        mediaTypes.put(".vddproj", "text/plain");
        mediaTypes.put(".vdp", "text/plain");
        mediaTypes.put(".vdproj", "text/plain");
        mediaTypes.put(".vdx", "application/vnd.ms-visio.viewer");
        mediaTypes.put(".vml", "text/xml");
        mediaTypes.put(".vscontent", "application/xml");
        mediaTypes.put(".vsct", "text/xml");
        mediaTypes.put(".vsd", "application/vnd.visio");
        mediaTypes.put(".vsi", "application/ms-vsi");
        mediaTypes.put(".vsix", "application/vsix");
        mediaTypes.put(".vsixlangpack", "text/xml");
        mediaTypes.put(".vsixmanifest", "text/xml");
        mediaTypes.put(".vsmdi", "application/xml");
        mediaTypes.put(".vspscc", "text/plain");
        mediaTypes.put(".vss", "application/vnd.visio");
        mediaTypes.put(".vsscc", "text/plain");
        mediaTypes.put(".vssettings", "text/xml");
        mediaTypes.put(".vssscc", "text/plain");
        mediaTypes.put(".vst", "application/vnd.visio");
        mediaTypes.put(".vstemplate", "text/xml");
        mediaTypes.put(".vsto", "application/x-ms-vsto");
        mediaTypes.put(".vsw", "application/vnd.visio");
        mediaTypes.put(".vsx", "application/vnd.visio");
        mediaTypes.put(".vtt", "text/vtt");
        mediaTypes.put(".vtx", "application/vnd.visio");
        mediaTypes.put(".wasm", "application/wasm");
        mediaTypes.put(".wav", "audio/wav");
        mediaTypes.put(".wave", "audio/wav");
        mediaTypes.put(".wax", "audio/x-ms-wax");
        mediaTypes.put(".wbk", "application/msword");
        mediaTypes.put(".wbmp", "image/vnd.wap.wbmp");
        mediaTypes.put(".wcm", "application/vnd.ms-works");
        mediaTypes.put(".wdb", "application/vnd.ms-works");
        mediaTypes.put(".wdp", "image/vnd.ms-photo");
        mediaTypes.put(".webarchive", "application/x-safari-webarchive");
        mediaTypes.put(".webm", "video/webm");
        // https://en.wikipedia.org/wiki/WebP
        mediaTypes.put(".webp", "image/webp");
        mediaTypes.put(".webtest", "application/xml");
        mediaTypes.put(".wiq", "application/xml");
        mediaTypes.put(".wiz", "application/msword");
        mediaTypes.put(".wks", "application/vnd.ms-works");
        mediaTypes.put(".WLMP", "application/wlmoviemaker");
        mediaTypes.put(".wlpginstall", "application/x-wlpg-detect");
        mediaTypes.put(".wlpginstall3", "application/x-wlpg3-detect");
        mediaTypes.put(".wm", "video/x-ms-wm");
        mediaTypes.put(".wma", "audio/x-ms-wma");
        mediaTypes.put(".wmd", "application/x-ms-wmd");
        mediaTypes.put(".wmf", "application/x-msmetafile");
        mediaTypes.put(".wml", "text/vnd.wap.wml");
        mediaTypes.put(".wmlc", "application/vnd.wap.wmlc");
        mediaTypes.put(".wmls", "text/vnd.wap.wmlscript");
        mediaTypes.put(".wmlsc", "application/vnd.wap.wmlscriptc");
        mediaTypes.put(".wmp", "video/x-ms-wmp");
        mediaTypes.put(".wmv", "video/x-ms-wmv");
        mediaTypes.put(".wmx", "video/x-ms-wmx");
        mediaTypes.put(".wmz", "application/x-ms-wmz");
        mediaTypes.put(".woff", "application/font-woff");
        mediaTypes.put(".woff2", "application/font-woff2");
        mediaTypes.put(".wpl", "application/vnd.ms-wpl");
        mediaTypes.put(".wps", "application/vnd.ms-works");
        mediaTypes.put(".wri", "application/x-mswrite");
        mediaTypes.put(".wrl", "x-world/x-vrml");
        mediaTypes.put(".wrz", "x-world/x-vrml");
        mediaTypes.put(".wsc", "text/scriptlet");
        mediaTypes.put(".wsdl", "text/xml");
        mediaTypes.put(".wvx", "video/x-ms-wvx");
        mediaTypes.put(".x", "application/directx");
        mediaTypes.put(".xaf", "x-world/x-vrml");
        mediaTypes.put(".xaml", "application/xaml+xml");
        mediaTypes.put(".xap", "application/x-silverlight-app");
        mediaTypes.put(".xbap", "application/x-ms-xbap");
        mediaTypes.put(".xbm", "image/x-xbitmap");
        mediaTypes.put(".xdr", "text/plain");
        mediaTypes.put(".xht", "application/xhtml+xml");
        mediaTypes.put(".xhtml", "application/xhtml+xml");
        mediaTypes.put(".xla", "application/vnd.ms-excel");
        mediaTypes.put(".xlam", "application/vnd.ms-excel.addin.macroEnabled.12");
        mediaTypes.put(".xlc", "application/vnd.ms-excel");
        mediaTypes.put(".xld", "application/vnd.ms-excel");
        mediaTypes.put(".xlk", "application/vnd.ms-excel");
        mediaTypes.put(".xll", "application/vnd.ms-excel");
        mediaTypes.put(".xlm", "application/vnd.ms-excel");
        mediaTypes.put(".xls", "application/vnd.ms-excel");
        mediaTypes.put(".xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12");
        mediaTypes.put(".xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12");
        mediaTypes.put(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        mediaTypes.put(".xlt", "application/vnd.ms-excel");
        mediaTypes.put(".xltm", "application/vnd.ms-excel.template.macroEnabled.12");
        mediaTypes.put(".xltx", "application/vnd.openxmlformats-officedocument.spreadsheetml.template");
        mediaTypes.put(".xlw", "application/vnd.ms-excel");
        mediaTypes.put(".xml", "text/xml");
        mediaTypes.put(".xmp", "application/octet-stream");
        mediaTypes.put(".xmta", "application/xml");
        mediaTypes.put(".xof", "x-world/x-vrml");
        mediaTypes.put(".XOML", "text/plain");
        mediaTypes.put(".xpm", "image/x-xpixmap");
        mediaTypes.put(".xps", "application/vnd.ms-xpsdocument");
        mediaTypes.put(".xrm-ms", "text/xml");
        mediaTypes.put(".xsc", "application/xml");
        mediaTypes.put(".xsd", "text/xml");
        mediaTypes.put(".xsf", "text/xml");
        mediaTypes.put(".xsl", "text/xml");
        mediaTypes.put(".xslt", "text/xml");
        mediaTypes.put(".xsn", "application/octet-stream");
        mediaTypes.put(".xss", "application/xml");
        mediaTypes.put(".xspf", "application/xspf+xml");
        mediaTypes.put(".xtp", "application/octet-stream");
        mediaTypes.put(".xwd", "image/x-xwindowdump");
        mediaTypes.put(".z", "application/x-compress");
        mediaTypes.put(".zip", "application/zip");
    }

    public static String getExtension(String mediaType) {
        for (Map.Entry<String, String> entry : mediaTypes.entrySet()) {
            if (mediaType.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return "";
    }

    public static String getMediaType(String extension) {
        if (StringUtils.isBlank(extension)) {
            return "";
        }
        if (!extension.startsWith(".")) {
            extension = "." + extension;
        }
        String typeOrDefault = mediaTypes.getOrDefault(extension, "");
        return StringUtils.isNotBlank(typeOrDefault) ? typeOrDefault : "application/octet-stream";
    }

    public static void main(String[] args) {
        System.out.println(getMediaType(".pdf"));
        System.out.println(getMediaType("pdf"));
        System.out.println(getExtension("application/pdf"));
    }
}
