
�
README.md 작성 필수
프로젝트에 대한 설명 및 정보를 README.md 파일에 반드시 작성합니다.
포함 내용
● 프로젝트 소개 (무엇을 만드는 프로그램인지)
● 주요 기능 설명
● CSV 파일 구조 설명
● 프로젝트 구조 설명 (패키지/클래스 역할)

# MenuProject
---
메뉴 관리 프로그램
관리되는 메뉴 정보는 **메뉴 번호**,**메뉴명**,**가격**,**카테고리**,**판매 여부**

---
## 주요 기능 설명
- 메뉴 등록
- 메뉴 삭제
- 메뉴 수정
- 전체 메뉴 조회
---
## CSV 파일 구조 설명
```csv
menuNo,name,price,category,sale
M001,아메리카노,4500,커피,Y
M002,카페라떼,5000,커피,Y
M003,치즈케이크,6500,디저트,N
```
| 컬럼명      | 설명 | 타입 |
|----------| --- | --- |
| menuNo   | 메뉴 번호 | String | 
| name     | 메뉴명 | String | 
| price    | 가격 | int | 
| category | 카테고리 | String | 
| sale     | 판매 여부 | boolean | 

## 프로젝트 구조
```
src
┣ controller
┃ ┣ Controller
┃ ┣ HandlerMapping
┃ ┣ InsertController
┃ ┣ DeleteController
┃ ┣ UpdateController
┃ ┣ SelectController
┃ ┗ PrintAllController
┣ exception
┃ ┗ MenuException
┣ service
┃ ┗ MenuService
┣ vo
┃ ┗ MenuVO
┣ main
┃ ┗ MenuMain
┗ menu.csv
```
---

## 프로그램 실행 흐름

1. 프로그램 실행
2. menu.csv 파일 데이터 로드
3. 사용자 메뉴 선택
4. CRUD 기능 수행
5. 프로그램 종료 시 CSV 저장

---