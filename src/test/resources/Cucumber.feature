#language: ru
Функционал: Ипотека

  @all
  @checkCalculatorIpoteka
  Сценарий: Иптечный калькулятор

    * выбрано меню "ипотека"
    * выбран подменю "ипотека на готовое жилье"
    * заполняем поле "Стоимость недвижимости" значения "5180000"
    * заполняем поле "Срок кредита" значения "30"
    * заполняем поле "Первоначальный взнос" значения "3058000"
    * выставляем чекбокс "Страхование жизни" в значение "false"
    * выставляем чекбокс "Молодая семья" в значение "true"
    * выполняем проверку что параметр "Ежемесячный платеж" равен значению "16922"
    * выполняем проверку что параметр "Сумма кредита" равен значению "2122000"
    * выполняем проверку что параметр "Необходимый доход" равен значению "21784"
    * выполняем проверку что параметр "Процентная ставка" равен значению "11"