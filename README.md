# 공연 조회 JAVA Android Application  (뭐보러갈래) Overview

https://docs.google.com/presentation/d/1WwfQ5CU3-UyYyVl5f6w5fggurQ5EiNB2GDk96inoQos/edit?usp=sharing

기획 :
- 1990년부터 2019년의 문화예술 관람률 이 약 2배 이상 증가함에 따라 공연 정보를 더욱 쉽게 제공하기 위한 프로젝트입니다.
- 데이터 분석과 인공지능을 활용할 수 있는 서비스 개발을 목표로 삼았습니다.

설계 :
- 서비스에 필요한 데이터 정보를 저장할 수 있도록 ERDCloud로 테이블 정의서 작업과 DB 구축을 진행하였습니다.
- 사이트 맵을 만들어 주요 기능을 정하고 화면 기획서를 만들었습니다.
- 화면 기획서를 기반으로 Postman을 통해 API 명세서를 만들었습니다.

개발 :
1. 데이터 분석 및 인공지능
- Colab을 사용하여 사용자의 리뷰정보를 토대로 공연을 추천해주는 협업 필터링을 구현했습니다.
- RDS에 저장된 사용자의 정보를 통해 서버 내에서 실시간으로 협업 필터링이 가능하게 하였습니다.
- Naver Clova OCR을 이용하여 S3에 저장된 사진의 자연어를 인식할 수 있는 기능을 구현하였습니다.

2. API
- Flask RESTful API를 생성하였습니다.
- 사용자 인증 및 식별을 위해 JWT 사용하였습니다.
- Flask RESTful API에 사용자 정보의 CRUD를 구현했습니다.
- Flask RESTful API에 리뷰의 CRUD를 구현했습니다.
- Flask RESTful API에 게시글의 CRUD를 구현했습니다.

3. AWS
- 사용자가 객체 URL을 통해 사진에 접근할 수 있도록 AWS S3 버킷 구성
- 서버와 자원 관리를 위해 Serverless 구성 및 AWS Lambda 함수 생성
- 계층(Layer)을 만들어 AWS Lambda에 라이브러리 적용
- IAM 액세스 키와 시크릿 키를 이용해 서버에 액세스하고 Serverless providers를 설정해 관리
- Serverless와 GitHub를 연동하여 GitHub에 Push 하면 자동으로 배포되도록 적용

4. DB
- Firebase의 Realtime Database를 이용한 채팅을 구현했습니다.
- 사용자 정보가 중복되지 않도록 Email 및 사용자 ID 들의 인덱스를 Unique 설정하였습니다.
- Python으로 API와 MySQL을 연동하였습니다.
- MySQL에서 검색에 사용되는 컬럼의 인덱스를 Full-text Search 설정하여 빠른 검색이 가능하게 하였습니다.
- MySQL에서 FK(Foreign Key)를 설정하여 테이블의 PK(Primary Key)가 되는 컬럼들을 연결하였습니다
- 회원가입 API를 호출하면 jwt 웹 토큰이 생성되어 사용자가 입력한 정보와 토큰 정보가 저장됩니다.
- 커뮤니티에서 게시글을 작성하면 작성한 사용자의 아이디와 게시글 정보가 저장됩니다.
- 공연에 리뷰를 작성하면 Rating 정보와 리뷰정보 및 유저아이디 정보가 저장됩니다.

5. 프론트엔드(Frontend)
- SharedPreferences를 사용하여 API에서 호출된 사용자의 정보를 저장하였습니다.
- Glide로 S3에 저장한 이미지를 클라이언트에 시각화하였습니다.
- Firebas Realtime Database를 이용한 채팅 기능을 시각화하였습니다.
- ViewPager2와 ScrollView, RecyclerView를 이용해 화면을 넓게 사용할 수 있도록 설계하였습니다.
- Spinner를 이용한 상세 검색 기능 구현하였습니다.
- Intent를 사용하여 액티비티 간의 데이터 전달 및 화면 전환을 구현했습니다.
- Adapter 및 ViewHolder 객체를 생성하여 리스트 데이터를 RecyclerView에 보일 수 있도록 구현했습니다.

테스트 :
≫ Postman에서 API 단위로 테스트하였습니다.
- API 개발 진행 시 Flask를 이용해 로컬테스트를 시행하였습니다.
- 버그가 발생 시 Log를 사용하며 해결하였습니다.

[로컬테스트 후] :
- API 정상 작동을 확인하고, AWS 서버에 Deploy 한 뒤 AWS 서버에서도 테스트를 진행하여 문제가 없는지 확인하였습니다.
- 서비스 서버로의 배포를 위해 GitHub에 Pull Request 후 Merge 하여 작업하였습니다.
- 테스트 완료한 API 컬렉션을 Postman에서 Export 한 후 다른 팀원들과 Slack으로 공유하였습니다

Fronted 기능 테스트
≫ Android Studio의 Device Emulator와 Run 및 Logcat을 확인하며 테스트를 진행하였습니다.
1. 데이터 전달 관련 기능을 테스트
- a. 전달할 데이터 혹은 받아온 데이터를 Log로 출력하여 정상적으로 받아오는지 테스트
- b. Logcat에서 확인하여 완료합니다.
2. 상호작용 관련 테스트
- a. 클라이언트가 요청한 기능을 제대로 호출할 수 있는지 테스트
- b. 클라이언트가 전달한 정보를 DB 또는 서버에 저장할 수 있는지 테스트
3. Device Emulator에서 테스트를 완료하였다면, 실기기도 사용하여 테스트
a. Device Emulator는 기본적으로 야간모드가 켜져 있지 않음
a-1. 야간모드를 사용 중인 실기기에서 테스트 결과 UI를 알아볼 수 없는 문제 발생
a-2. 앱 내의 다크모드 사용을 제한하는 MODE_NIGHT_NO를 사용하여 해결




사용된 Open API
1. 공연 예술 통합 전산망 KOPIS
- 공연 목록 및 시설 목록 조회를 위한 API입니다.
2. Google Maps
- GPS 위치를 기반으로 주변 공연 정보를 안내합니다.
- 공연 중인 시설을 지도에 표시하고, 해당 공연 정보를 Marker로 생성
- 해당 Marker를 클릭 시 공연의 상세 정보를 보여줍니다.
3. 네이버 클로바 OCR
- 자연어를 인식할 수 있는 기능을 구현
- 티켓 이미지 판독 후 인증 여부 확인


# Open API
- 공연전시KOPIS
- Google Maps
- 클로바 OCR

#  OpenSource Library
- ViewPager2
- retrofit2
- Glide
- firebase
- yoyo
- Commons IO

# App SiteMap
![readMe_SiteMap](https://user-images.githubusercontent.com/105832386/190550178-7716bb56-ba26-415c-9301-592576646acd.png)

# Important files
### **메인**
-  MainActivity : 앱 기본 구조가 4개의 프래그먼트를 메인으로 작동하기 때문에 메인 액티비티에서는 BottomNavigationView 를 이용해 프래그먼트의 화면 전환시켜주는 기능이 존재한다. 

### **홈 화면**
  - HomeFragment : 앱에 로그인하면 가장 먼저 만날 수 있는 화면으로 이미지 배너와 여러 공연 리스트로 이루어져 있다.
    - 검색기능 : 여러 조건을 설정하여 공연을 검색할 수 있다.
    - 내 취향 공연 보기 : 사용자 경험을 토대로 사용자가 좋아할만한 공연을 자동으로 추천해준다.
    - 각 공연을 눌러 공연 상세 정보를 볼 수 있는 액티비티로 이동할 수 있다.

### **내 주변 공연 찾기 (지도)**
  - MapFragment : Google Map API를 이용하였으며, 사용자의 GPS위치를 기반으로 주변 공연을 찾아준다.
    - 지도에 공연정보를 띄워주고 클릭 시 해당 공연 정보를 열람할 수 있다.

### **커뮤니티**
  - CommunityFragment : 파티 찾기 기능과 자유게시판, 유저 리뷰를 작성 열람 수정 삭제가 가능하다. 
    - 파티 찾기 : Firebase를 이용하여 채팅창 만들고, 이를 통해 유저들이 자유롭게 방을 만들고 소통할 수 있게 하였다.
    - 자유게시판 : 로그인된 유저라면 모두 자유롭게 글을 열람하고 자신의 글을 작성하고 수정, 삭제할 수 있다.
    - 리뷰게시판 : 유저가 공연을 보고 리뷰를 작성할 때, 티켓 사진을 올리면 클로바 OCR을 통해 티켓 속 텍스트를 추출하여 리뷰를 올리려는 공연과 맞는 티켓인지 판단하고 맞다면 티켓인증 마크와 함께 리뷰를 게시할 수 있다.  

### **내 정보**
  - MyPageFragment: 사용자가 활동한 기록과 유저 정보를 수정하고 회원탈퇴가 가능하다.

# 실제 구동 화면

<img src="https://user-images.githubusercontent.com/105832386/190554589-34740111-84ba-43e7-935c-3c49ea36772c.png" width="300" height="300"><img src="https://user-images.githubusercontent.com/105832386/190554594-c91215f0-8358-47a7-95b3-24e7b301a9f7.png" width="300" height="300"><img src="https://user-images.githubusercontent.com/105832386/190554596-680e9d29-4e1f-452f-bf71-5a7b6dd50c5a.png" width="300" height="300"><img src="https://user-images.githubusercontent.com/105832386/190554597-54a118a8-972b-4354-b06a-fbe98e127b4b.png" width="300" height="300"><img src="https://user-images.githubusercontent.com/105832386/190554599-60a95d1b-faad-4eaf-bc27-5817436f9c4f.png" width="300" height="300"><img src="https://user-images.githubusercontent.com/105832386/190554603-992aac1c-b601-48c5-ab1e-bd883be6ec81.png" width="300" height="300">


- 개발기술서 Google Slides 주소: https://docs.google.com/presentation/d/1BJ2cNw5j3P4FOtlDy8OxZ3UoWne1K10SR-14FXz_giI/edit?usp=sharing
- 화면 UI 기획서 Oven 주소: https://ovenapp.io/view/mPoCI4eiLuu7fKlOjkeaHgkUKuUto8Qr/DRB62
- 테이블정의서 ErdCloud 주소: https://www.erdcloud.com/d/5v5C9THyddnhXEpKg
- API 명세서 Postman 주소: https://documenter.getpostman.com/view/21511170/2s7YYu7imm
- 서버 소스코드 Github 주소: https://github.com/eyoo95/perform-server-aws
