<h1 align="center">Image Radio Button</h1>

<p align="center">
  <a href="http://developer.android.com/index.html"><img alt="Android" src="https://img.shields.io/badge/platform-android-green.svg"/></a>
  <a href="https://jitpack.io/#raheemadamboev/image-radio-button-android"><img alt="Version" src="https://jitpack.io/v/raheemadamboev/image-radio-button-android.svg"/></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

<p align="center">
📻 Light library that is beautiful custom radio button with image functionality. You can easily add image to radio button. Integration is very easy.
</p>

# Setup

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
# Implementation

Add **GravityRadioGroup** to your XML layout:
```xml
<xyz.teamgravity.imageradiobutton.GravityRadioGroup
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
```

Add **GravityImageRadioButton** inside the **GravityRadioGroup** and set **required** attributes below:

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

# Attributes

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

# Demo

<p align="center">
  <img width="440" height="456" src="https://github.com/raheemadamboev/image-radio-button-android/blob/master/background.gif" />
</p>

Programming pictures are placed with the help of this library in this demo application. When radio button is clicked, its text gets shown via Toast.

<a href="https://github.com/raheemadamboev/image-radio-button-android/blob/master/app-debug.apk">Download demo</a>

# Projects using this library

**GoTest** 150 000+ downloads in <a href="https://play.google.com/store/apps/details?id=xyz.teamgravity.gotest">Google Play Store</a>

**Buxgalteriya schyotlar rejasi** 20 000+ downloads in <a href="https://play.google.com/store/apps/details?id=xyz.teamgravity.uzbekistanaccountingcode">Google Play Store</a>

**Irregular Verbs**  20 000+ downloads in <a href="https://play.google.com/store/apps/details?id=xyz.teamgravity.irregularverbs">Google Play Store</a>

# License

```xml
Designed and developed by raheemadamboev (Raheem) 2022.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
