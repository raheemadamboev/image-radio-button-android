# image-radio-button-android
Beautiful custom radio button with image functionality

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![](https://jitpack.io/v/raheemadamboev/image-radio-button-android.svg)](https://jitpack.io/#raheemadamboev/image-radio-button-android)

Light library that adds image to a beautiful custom radio button. You can easily add image to radio button. Integration is very easy and many popular Android applications are using this library.

## How To use

Add it in your root **build.gradle** at the end of repositories:
```groovy
allprojects {
  repositories {
	  maven { url 'https://jitpack.io' }
  }
}
```  

Include below dependency in build.gradle of application and sync it:
```groovy
implementation 'com.github.raheemadamboev:image-radio-button-android:1.0.4'
```

Add **GravityRadioGroup** to your XML layout:
```xml
<xyz.teamgravity.imageradiobutton.GravityRadioGroup
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
```

Add **GravityImageRadioButton** inside the **GravityRadioGroup** and set **compulsory** attributes below:

```xml
<xyz.teamgravity.imageradiobutton.GravityRadioGroup
  ...
 >

<xyz.teamgravity.imageradiobutton.GravityImageRadioButton
	android:id="@+id/android_b"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:padding="20dp"
        app:girbImage="@drawable/android"
        app:girbPressedTextColor="@color/white"
        app:girbText="Android"
        app:girbUnpressedTextColor="?attr/colorPrimary" />
            
</xyz.teamgravity.imageradiobutton.GravityRadioGroup>
```

**Attributes:**

| Attribute                             | Type          | Usage                                                                |
| --------------------------------------| ------------- | -------------------------------------------------------------------- |
| `app:girbText`                        | string        | String to display                                        	       |
| `app:girbUnpressedTextColor`          | color         | Color of text when radio button is unpressed/unchecked               |
| `app:girbPressedTextColor`            | color         | Color of text when radio button is pressed/checked                   |
| `app:girbImage`                       | drawable      | Image drawable to display                                            |
| `app:girbUnpressedImageTint`          | color         | Tint color of image when radio button is unpressed/unchecked         | 
| `app:girbPressedImageTint`            | color         | Tint color of image when radio button is pressed/checked             | 
| `app:girbPressedBackgroundDrawable`   | drawable      | Background drawable when radio button is pressed/checked             | 

_If you don't want to set tint to ImageView of RadioButton, just don't set_ `app:girbUnpressedImageTint` _and_ `app:girbPressedImageTint` _attributes in XML!_

## Demo application

<img src="https://github.com/raheemadamboev/image-radio-button-android/blob/master/background.gif" alt="sample" title="sample" width="440" height="456" align="left" vspace="60" />

Programming pictures are placed with the help of this library in this demo application. When radio button clicked, its text gets shown in Toast.

<a href="https://github.com/raheemadamboev/image-radio-button-android/blob/master/app-debug.apk">Download demo</a>

## Projects using this library

**GoTest** 80 000+ downloads in <a href="https://play.google.com/store/apps/details?id=xyz.teamgravity.gotest">Google Play Store</a>

**Buxgalteriya schyotlar rejasi** 5 000+ downloads in <a href="https://play.google.com/store/apps/details?id=xyz.teamgravity.uzbekistanaccountingcode">Google Play Store</a>

**Irregular Verbs**  1 000+ downloads in <a href="https://play.google.com/store/apps/details?id=xyz.teamgravity.irregularverbs">Google Play Store</a>

...
